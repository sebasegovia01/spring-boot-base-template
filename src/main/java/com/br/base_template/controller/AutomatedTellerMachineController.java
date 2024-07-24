package com.br.base_template.controller;

import com.br.base_template.dto.AutomatedTellerMachineDto;
import com.br.base_template.dto.RequestDto;
import com.br.base_template.model.AutomatedTellerMachine;
import com.br.base_template.service.AutomatedTellerMachineService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/automated-teller-machines")
@Validated
public class AutomatedTellerMachineController {

    private final AutomatedTellerMachineService service;

    public AutomatedTellerMachineController(AutomatedTellerMachineService service) {
        this.service = service;
    }

    @GetMapping
    public List<AutomatedTellerMachine> getAll() {
        return service.findAll();
    }

    @GetMapping("/{atmIdentifier}")
    public AutomatedTellerMachine getById(@PathVariable String atmIdentifier) {
        return service.findById(atmIdentifier);
    }

    @PostMapping
    public AutomatedTellerMachine create(@Valid @RequestBody RequestDto requestDto) {
        AutomatedTellerMachineDto dto = requestDto.getPresentialServiceChannels();
        AutomatedTellerMachine entity = new AutomatedTellerMachine();
        entity.setAtmIdentifier(dto.getAtmIdentifier());
        entity.setAtmAddressStreetName(dto.getAtmAddressStreetName());
        entity.setAtmAddressBuildingNumber(dto.getAtmAddressBuildingNumber());
        entity.setAtmTownName(dto.getAtmTownName());
        entity.setAtmDistrictName(dto.getAtmDistrictName());
        entity.setAtmCountrySubDivisionMajorName(dto.getAtmCountrySubDivisionMajorName());
        entity.setAtmFromDatetime(dto.getAtmFromDatetime());
        entity.setAtmToDatetime(dto.getAtmToDatetime());
        entity.setAtmTimeType(dto.getAtmTimeType());
        entity.setAtmAttentionHour(dto.getAtmAttentionHour());
        entity.setAtmServiceType(dto.getAtmServiceType());
        entity.setAtmAccessType(dto.getAtmAccessType());
        return service.save(entity);
    }

    @DeleteMapping("/{atmIdentifier}")
    public void delete(@PathVariable String atmIdentifier) {
        AutomatedTellerMachine entity = service.findById(atmIdentifier);
        service.deleteById(entity.getId());
    }

    @PutMapping("/{atmIdentifier}")
    public AutomatedTellerMachine update(@PathVariable String atmIdentifier, @Valid @RequestBody RequestDto requestDto) {
        AutomatedTellerMachineDto dto = requestDto.getPresentialServiceChannels();
        AutomatedTellerMachine existingEntity = service.findById(atmIdentifier);
        existingEntity.setAtmIdentifier(dto.getAtmIdentifier());
        existingEntity.setAtmAddressStreetName(dto.getAtmAddressStreetName());
        existingEntity.setAtmAddressBuildingNumber(dto.getAtmAddressBuildingNumber());
        existingEntity.setAtmTownName(dto.getAtmTownName());
        existingEntity.setAtmDistrictName(dto.getAtmDistrictName());
        existingEntity.setAtmCountrySubDivisionMajorName(dto.getAtmCountrySubDivisionMajorName());
        existingEntity.setAtmFromDatetime(dto.getAtmFromDatetime());
        existingEntity.setAtmToDatetime(dto.getAtmToDatetime());
        existingEntity.setAtmTimeType(dto.getAtmTimeType());
        existingEntity.setAtmAttentionHour(dto.getAtmAttentionHour());
        existingEntity.setAtmServiceType(dto.getAtmServiceType());
        existingEntity.setAtmAccessType(dto.getAtmAccessType());
        return service.save(existingEntity);
    }
}
