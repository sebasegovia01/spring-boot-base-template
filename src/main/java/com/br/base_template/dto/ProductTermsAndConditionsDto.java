package com.br.base_template.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProductTermsAndConditionsDto {

    @JsonProperty("TYCFrequencyCode")
    @NotBlank(message = "TYCFrequencyCode is mandatory")
    @Size(max = 10, message = "TYCFrequencyCode must be up to 10 characters")
    private String tycFrequencyCode;

    @JsonProperty("TYCBenefitsDescription")
    @NotBlank(message = "TYCBenefitsDescription is mandatory")
    @Size(max = 50, message = "TYCBenefitsDescription must be up to 50 characters")
    private String tycBenefitsDescription;

    // Getters y Setters
    public String getTycFrequencyCode() {
        return tycFrequencyCode;
    }

    public void setTycFrequencyCode(String tycFrequencyCode) {
        this.tycFrequencyCode = tycFrequencyCode;
    }

    public String getTycBenefitsDescription() {
        return tycBenefitsDescription;
    }

    public void setTycBenefitsDescription(String tycBenefitsDescription) {
        this.tycBenefitsDescription = tycBenefitsDescription;
    }
}