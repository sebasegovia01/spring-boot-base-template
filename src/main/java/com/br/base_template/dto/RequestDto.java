package com.br.base_template.dto;

import jakarta.validation.Valid;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestDto {

    @JsonProperty("PresentialServiceChannels")
    @Valid
    private AutomatedTellerMachineDto presentialServiceChannels;

    // Getters y Setters
    public AutomatedTellerMachineDto getPresentialServiceChannels() {
        return presentialServiceChannels;
    }

    public void setPresentialServiceChannels(AutomatedTellerMachineDto presentialServiceChannels) {
        this.presentialServiceChannels = presentialServiceChannels;
    }
}
