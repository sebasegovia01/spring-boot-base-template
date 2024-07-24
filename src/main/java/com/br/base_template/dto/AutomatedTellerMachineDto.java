package com.br.base_template.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class AutomatedTellerMachineDto {

    @JsonProperty("ATMIdentifier")
    @NotBlank(message = "ATMIdentifier is mandatory")
    @Size(max = 16, message = "ATMIdentifier must be up to 16 characters")
    private String atmIdentifier;

    @JsonProperty("ATMAddress_StreetName")
    @Size(max = 70, message = "ATMAddress_StreetName must be up to 70 characters")
    private String atmAddressStreetName;

    @JsonProperty("ATMAddress_BuildingNumber")
    @Size(max = 16, message = "ATMAddress_BuildingNumber must be up to 16 characters")
    private String atmAddressBuildingNumber;

    @JsonProperty("ATMTownName")
    @Size(max = 35, message = "ATMTownName must be up to 35 characters")
    private String atmTownName;

    @JsonProperty("ATMDistrictName")
    @Size(max = 35, message = "ATMDistrictName must be up to 35 characters")
    private String atmDistrictName;

    @JsonProperty("ATMCountrySubDivisionMajorName")
    @Size(max = 35, message = "ATMCountrySubDivisionMajorName must be up to 35 characters")
    private String atmCountrySubDivisionMajorName;

    @JsonProperty("ATMFromDatetime")
    @NotNull(message = "ATMFromDatetime is mandatory")
    private LocalDateTime atmFromDatetime;

    @JsonProperty("ATMToDatetime")
    @NotNull(message = "ATMToDatetime is mandatory")
    private LocalDateTime atmToDatetime;

    @JsonProperty("ATMTimeType")
    @Size(max = 35, message = "ATMTimeType must be up to 35 characters")
    private String atmTimeType;

    @JsonProperty("ATMAttentionHour")
    @Size(max = 50, message = "ATMAttentionHour must be up to 50 characters")
    private String atmAttentionHour;

    @JsonProperty("ATMServiceType")
    @NotBlank(message = "ATMServiceType is mandatory")
    @Size(max = 4, message = "ATMServiceType must be up to 4 characters")
    private String atmServiceType;

    @JsonProperty("ATMAccessType")
    @NotBlank(message = "ATMAccessType is mandatory")
    @Size(max = 4, message = "ATMAccessType must be up to 4 characters")
    private String atmAccessType;

    // Getters y Setters
    public String getAtmIdentifier() {
        return atmIdentifier;
    }

    public void setAtmIdentifier(String atmIdentifier) {
        this.atmIdentifier = atmIdentifier;
    }

    public String getAtmAddressStreetName() {
        return atmAddressStreetName;
    }

    public void setAtmAddressStreetName(String atmAddressStreetName) {
        this.atmAddressStreetName = atmAddressStreetName;
    }

    public String getAtmAddressBuildingNumber() {
        return atmAddressBuildingNumber;
    }

    public void setAtmAddressBuildingNumber(String atmAddressBuildingNumber) {
        this.atmAddressBuildingNumber = atmAddressBuildingNumber;
    }

    public String getAtmTownName() {
        return atmTownName;
    }

    public void setAtmTownName(String atmTownName) {
        this.atmTownName = atmTownName;
    }

    public String getAtmDistrictName() {
        return atmDistrictName;
    }

    public void setAtmDistrictName(String atmDistrictName) {
        this.atmDistrictName = atmDistrictName;
    }

    public String getAtmCountrySubDivisionMajorName() {
        return atmCountrySubDivisionMajorName;
    }

    public void setAtmCountrySubDivisionMajorName(String atmCountrySubDivisionMajorName) {
        this.atmCountrySubDivisionMajorName = atmCountrySubDivisionMajorName;
    }

    public LocalDateTime getAtmFromDatetime() {
        return atmFromDatetime;
    }

    public void setAtmFromDatetime(LocalDateTime atmFromDatetime) {
        this.atmFromDatetime = atmFromDatetime;
    }

    public LocalDateTime getAtmToDatetime() {
        return atmToDatetime;
    }

    public void setAtmToDatetime(LocalDateTime atmToDatetime) {
        this.atmToDatetime = atmToDatetime;
    }

    public String getAtmTimeType() {
        return atmTimeType;
    }

    public void setAtmTimeType(String atmTimeType) {
        this.atmTimeType = atmTimeType;
    }

    public String getAtmAttentionHour() {
        return atmAttentionHour;
    }

    public void setAtmAttentionHour(String atmAttentionHour) {
        this.atmAttentionHour = atmAttentionHour;
    }

    public String getAtmServiceType() {
        return atmServiceType;
    }

    public void setAtmServiceType(String atmServiceType) {
        this.atmServiceType = atmServiceType;
    }

    public String getAtmAccessType() {
        return atmAccessType;
    }

    public void setAtmAccessType(String atmAccessType) {
        this.atmAccessType = atmAccessType;
    }
}
