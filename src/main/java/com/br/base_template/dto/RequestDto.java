package com.br.base_template.dto;

import jakarta.validation.Valid;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestDto {

    @JsonProperty("ProductTermsAndConditions")
    @Valid
    private ProductTermsAndConditionsDto productTermsAndConditions;

    // Getters y Setters
    public ProductTermsAndConditionsDto getProductTermsAndConditions() {
        return productTermsAndConditions;
    }

    public void setProductTermsAndConditions(ProductTermsAndConditionsDto productTermsAndConditions) {
        this.productTermsAndConditions = productTermsAndConditions;
    }
}