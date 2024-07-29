package com.br.base_template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class RedisConnectionChecker implements CommandLineRunner {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void run(String... args) throws Exception {
        try (RedisConnection connection = Objects.requireNonNull(redisTemplate.getConnectionFactory()).getConnection()) {
            String pingResponse = connection.ping();
            if ("PONG".equals(pingResponse)) {
                System.out.println("Redis connection successful, PING response: " + pingResponse);
            } else {
                System.err.println("Redis connection failed, unexpected PING response: " + pingResponse);
            }
        } catch (Exception e) {
            System.err.println("Redis connection failed: " + e.getMessage());
        }
    }
}
