package com.br.base_template.service;

import com.br.base_template.model.AutomatedTellerMachine;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.PubsubMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;

@Service
public class PubSubSubscriberService {

    private final PubSubTemplate pubSubTemplate;
    private final RedisTemplate<String, String> redisTemplate;
    private final GoogleCloudStorageService googleCloudStorageService;
    private final AutomatedTellerMachineService atmService;
    private final ObjectMapper objectMapper;

    @Value("${gcp.project-id}")
    private String projectId;

    @Value("${gcp.subscription-id}")
    private String subscriptionId;

    @Value("${processed.message.expiration.minutes}")
    private int expirationTimeInMinutes;

    public PubSubSubscriberService(PubSubTemplate pubSubTemplate, RedisTemplate<String, String> redisTemplate,
                                   GoogleCloudStorageService googleCloudStorageService,
                                   AutomatedTellerMachineService atmService) {
        this.pubSubTemplate = pubSubTemplate;
        this.redisTemplate = redisTemplate;
        this.googleCloudStorageService = googleCloudStorageService;
        this.atmService = atmService;
        this.objectMapper = new ObjectMapper();
    }

    @PostConstruct
    public void subscribe() {
        ProjectSubscriptionName subscriptionName = ProjectSubscriptionName.of(projectId, subscriptionId);
        Subscriber subscriber = Subscriber.newBuilder(subscriptionName, this::receiveMessage).build();
        subscriber.startAsync().awaitRunning();
    }

    private void receiveMessage(PubsubMessage message, AckReplyConsumer consumer) {
        String messageData = message.getData().toStringUtf8();
        String messageId = generateMessageId(messageData);

        Boolean isDuplicate = redisTemplate.opsForValue().setIfAbsent(messageId, "processed", expirationTimeInMinutes, TimeUnit.MINUTES);

        if (isDuplicate == null || !isDuplicate) {
            // Message ID already exists, skip processing
            consumer.ack(); // Acknowledge the message to prevent re-delivery
            return;
        }

        // Process the message
        System.out.println("Message data: " + messageData);

        try {
            JsonNode messageJson = objectMapper.readTree(messageData);
            String bucket = messageJson.get("bucket").asText();
            String name = messageJson.get("name").asText();
            String fileContent = googleCloudStorageService.downloadFileContent(bucket, name);
            System.out.println("File content: " + fileContent);

            // Parse the file content into JsonNode
            JsonNode fileContentJson = objectMapper.readTree(fileContent);

            // Extract the payload part
            JsonNode payload = fileContentJson.get("payload");

            // Convert payload to AutomatedTellerMachine object
            AutomatedTellerMachine atm = new AutomatedTellerMachine();
            atm.setAtmIdentifier(payload.get("atmidentifier").asText());
            atm.setAtmAddressStreetName(payload.get("atmaddress_streetname").asText());
            atm.setAtmAddressBuildingNumber(payload.get("atmaddress_buildingnumber").asText());
            atm.setAtmTownName(payload.get("atmtownname").asText());
            atm.setAtmDistrictName(payload.get("atmdistrictname").asText());
            atm.setAtmCountrySubDivisionMajorName(payload.get("atmcountrysubdivisionmajorname").asText());
            atm.setAtmFromDatetime(LocalDateTime.parse(payload.get("atmfromdatetime").asText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
            atm.setAtmToDatetime(LocalDateTime.parse(payload.get("atmtodatetime").asText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
            atm.setAtmTimeType(payload.get("atmtimetype").asText());
            atm.setAtmAttentionHour(payload.get("atmattentionhour").asText());
            atm.setAtmServiceType(payload.get("atmservicetype").asText());
            atm.setAtmAccessType(payload.get("atmaccesstype").asText());

            // Save the AutomatedTellerMachine object to the database
            atmService.save(atm);

            System.out.println("Saved AutomatedTellerMachine: " + atm);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Acknowledge the message after processing
        consumer.ack();
    }

    private String generateMessageId(String messageData) {
        CRC32 crc32 = new CRC32();
        crc32.update(messageData.getBytes(StandardCharsets.UTF_8));
        return Long.toHexString(crc32.getValue());
    }
}
