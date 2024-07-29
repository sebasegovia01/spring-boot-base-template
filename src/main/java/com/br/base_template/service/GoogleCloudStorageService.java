package com.br.base_template.service;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class GoogleCloudStorageService {

    private final Storage storage;

    public GoogleCloudStorageService() {
        this.storage = StorageOptions.getDefaultInstance().getService();
    }

    public String downloadFileContent(String bucketName, String objectName) {
        Blob blob = storage.get(bucketName, objectName);
        if (blob != null) {
            return new String(blob.getContent(), StandardCharsets.UTF_8);
        } else {
            throw new RuntimeException("No such object exists in the bucket.");
        }
    }
}
