package com.br.base_template.dto;

import jakarta.validation.Valid;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestDto {

    @JsonProperty("ATM")
    @Valid
    private ATMDto atm;

    // Getters and Setters
    public ATMDto getAtm() {
        return atm;
    }

    public void setAtm(ATMDto atm) {
        this.atm = atm;
    }
}
