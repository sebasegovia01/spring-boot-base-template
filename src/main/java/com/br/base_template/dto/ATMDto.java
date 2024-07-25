package com.br.base_template.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

public class ATMDto {

    @NotNull
    @Size(max = 16)
    private String ATMIdentifier;

    @Size(max = 70)
    private String ATMAddressStreetName;

    @Size(max = 16)
    private String ATMAddressBuildingNumber;

    @Size(max = 35)
    private String ATMTownName;

    @Size(max = 35)
    private String ATMDistrictName;

    @Size(max = 35)
    private String ATMCountrySubDivisionMajorName;

    @NotNull
    private LocalDateTime ATMFromDatetime;

    @NotNull
    private LocalDateTime ATMToDatetime;

    @Size(max = 35)
    private String ATMTimeType;

    private String ATMAttentionHour;

    @NotNull
    @Size(max = 4)
    private String ATMServiceType;

    @NotNull
    @Size(max = 4)
    private String ATMAccessType;

    // Getters and Setters
    public String getATMIdentifier() {
        return ATMIdentifier;
    }

    public void setATMIdentifier(String ATMIdentifier) {
        this.ATMIdentifier = ATMIdentifier;
    }

    public String getATMAddressStreetName() {
        return ATMAddressStreetName;
    }

    public void setATMAddressStreetName(String ATMAddressStreetName) {
        this.ATMAddressStreetName = ATMAddressStreetName;
    }

    public String getATMAddressBuildingNumber() {
        return ATMAddressBuildingNumber;
    }

    public void setATMAddressBuildingNumber(String ATMAddressBuildingNumber) {
        this.ATMAddressBuildingNumber = ATMAddressBuildingNumber;
    }

    public String getATMTownName() {
        return ATMTownName;
    }

    public void setATMTownName(String ATMTownName) {
        this.ATMTownName = ATMTownName;
    }

    public String getATMDistrictName() {
        return ATMDistrictName;
    }

    public void setATMDistrictName(String ATMDistrictName) {
        this.ATMDistrictName = ATMDistrictName;
    }

    public String getATMCountrySubDivisionMajorName() {
        return ATMCountrySubDivisionMajorName;
    }

    public void setATMCountrySubDivisionMajorName(String ATMCountrySubDivisionMajorName) {
        this.ATMCountrySubDivisionMajorName = ATMCountrySubDivisionMajorName;
    }

    public LocalDateTime getATMFromDatetime() {
        return ATMFromDatetime;
    }

    public void setATMFromDatetime(LocalDateTime ATMFromDatetime) {
        this.ATMFromDatetime = ATMFromDatetime;
    }

    public LocalDateTime getATMToDatetime() {
        return ATMToDatetime;
    }

    public void setATMToDatetime(LocalDateTime ATMToDatetime) {
        this.ATMToDatetime = ATMToDatetime;
    }

    public String getATMTimeType() {
        return ATMTimeType;
    }

    public void setATMTimeType(String ATMTimeType) {
        this.ATMTimeType = ATMTimeType;
    }

    public String getATMAttentionHour() {
        return ATMAttentionHour;
    }

    public void setATMAttentionHour(String ATMAttentionHour) {
        this.ATMAttentionHour = ATMAttentionHour;
    }

    public String getATMServiceType() {
        return ATMServiceType;
    }

    public void setATMServiceType(String ATMServiceType) {
        this.ATMServiceType = ATMServiceType;
    }

    public String getATMAccessType() {
        return ATMAccessType;
    }

    public void setATMAccessType(String ATMAccessType) {
        this.ATMAccessType = ATMAccessType;
    }
}
