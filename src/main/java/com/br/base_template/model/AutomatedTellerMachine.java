package com.br.base_template.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.time.LocalDateTime;

@Entity
@Table(name = "automated_teller_machines", schema = "presential_service_channels")
public class AutomatedTellerMachine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "atmidentifier", nullable = false, length = 16)
    private String atmIdentifier;

    @Column(name = "atmaddress_streetname", length = 70)
    private String atmAddressStreetName;

    @Column(name = "atmaddress_buildingnumber", length = 16)
    private String atmAddressBuildingNumber;

    @Column(name = "atmtownname", length = 35)
    private String atmTownName;

    @Column(name = "atmdistrictname", length = 35)
    private String atmDistrictName;

    @Column(name = "atmcountrysubdivisionmajorname", length = 35)
    private String atmCountrySubDivisionMajorName;

    @Column(name = "atmfromdatetime", nullable = false)
    private LocalDateTime atmFromDatetime;

    @Column(name = "atmtodatetime", nullable = false)
    private LocalDateTime atmToDatetime;

    @Column(name = "atmtimetype", length = 35)
    private String atmTimeType;

    @Column(name = "atmattentionhour", length = 50)
    private String atmAttentionHour;

    @Column(name = "atmservicetype", nullable = false, length = 4)
    private String atmServiceType;

    @Column(name = "atmaccesstype", nullable = false, length = 4)
    private String atmAccessType;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
