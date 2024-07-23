package com.br.base_template.exception;

import com.br.base_template.common.RespStatus;

public class ErrorResponse {
    private RespStatus status;
    private String description;
    private CanonicalError canonicalError;
    private SourceError sourceError;

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

    public CanonicalError getCanonicalError() {
        return canonicalError;
    }

    public void setCanonicalError(CanonicalError canonicalError) {
        this.canonicalError = canonicalError;
    }

    public SourceError getSourceError() {
        return sourceError;
    }

    public void setSourceError(SourceError sourceError) {
        this.sourceError = sourceError;
    }
}