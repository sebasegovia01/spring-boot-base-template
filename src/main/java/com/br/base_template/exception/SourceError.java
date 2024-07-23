package com.br.base_template.exception;

public class SourceError {
    private String code;
    private String description;
    private ErrorSourceDetails errorSourceDetails;

    // Getters y Setters

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ErrorSourceDetails getErrorSourceDetails() {
        return errorSourceDetails;
    }

    public void setErrorSourceDetails(ErrorSourceDetails errorSourceDetails) {
        this.errorSourceDetails = errorSourceDetails;
    }

    public static class ErrorSourceDetails {
        private ErrorSource source;

        // Getters y Setters

        public ErrorSource getSource() {
            return source;
        }

        public void setSource(ErrorSource source) {
            this.source = source;
        }
    }
}
