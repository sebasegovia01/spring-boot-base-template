package com.br.base_template.dto;

public class HealthCheckResponse {
    private String status;

    public HealthCheckResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}