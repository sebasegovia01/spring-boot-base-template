package com.br.base_template.service;

import com.br.base_template.model.ProductTermsAndConditions;
import com.br.base_template.repository.ProductTermsAndConditionsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTermsAndConditionsService {

    private final ProductTermsAndConditionsRepository repository;

    public ProductTermsAndConditionsService(ProductTermsAndConditionsRepository repository) {
        this.repository = repository;
    }

    public List<ProductTermsAndConditions> findAll() {
        return repository.findAll();
    }

    public ProductTermsAndConditions save(ProductTermsAndConditions entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
