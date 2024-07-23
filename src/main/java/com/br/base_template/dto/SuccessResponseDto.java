package com.br.base_template.dto;

import com.br.base_template.common.RespStatus;

public class SuccessResponseDto<T> {
    private RespStatus status;
    private String description;
    private T result;

    // Getters y Setters
    public RespStatus getStatus() {
        return status;
    }

    public void setStatus(RespStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}