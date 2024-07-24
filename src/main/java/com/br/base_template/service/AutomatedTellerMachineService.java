package com.br.base_template.service;

import com.br.base_template.exception.ResourceNotFoundException;
import com.br.base_template.model.AutomatedTellerMachine;
import com.br.base_template.repository.AutomatedTellerMachineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutomatedTellerMachineService {

    private final AutomatedTellerMachineRepository repository;

    public AutomatedTellerMachineService(AutomatedTellerMachineRepository repository) {
        this.repository = repository;
    }

    public List<AutomatedTellerMachine> findAll() {
        return repository.findAll();
    }

    public AutomatedTellerMachine save(AutomatedTellerMachine entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public AutomatedTellerMachine findById(String atmIdentifier) {
        return repository.findByAtmIdentifier(atmIdentifier)
                .orElseThrow(() -> new ResourceNotFoundException("AutomatedTellerMachine not found"));
    }
}
