package com.br.base_template.controller;

import com.br.base_template.dto.ProductTermsAndConditionsDto;
import com.br.base_template.dto.RequestDto;
import com.br.base_template.model.ProductTermsAndConditions;
import com.br.base_template.service.ProductTermsAndConditionsService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/terms")
@Validated
public class ProductTermsAndConditionsController {

    private final ProductTermsAndConditionsService service;

    public ProductTermsAndConditionsController(ProductTermsAndConditionsService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProductTermsAndConditions> getAll() {
        return service.findAll();
    }

    @PostMapping
    public ProductTermsAndConditions create(@Valid @RequestBody RequestDto requestDto) {
        ProductTermsAndConditionsDto dto = requestDto.getProductTermsAndConditions();
        ProductTermsAndConditions entity = new ProductTermsAndConditions();
        entity.setTycFrequencyCode(dto.getTycFrequencyCode());
        entity.setTycBenefitsDescription(dto.getTycBenefitsDescription());
        return service.save(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}