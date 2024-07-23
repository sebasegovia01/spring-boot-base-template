package com.br.base_template.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_terms_and_conditions", schema = "sandbox")
public class ProductTermsAndConditions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tycFrequencyCode;
    private String tycBenefitsDescription;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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