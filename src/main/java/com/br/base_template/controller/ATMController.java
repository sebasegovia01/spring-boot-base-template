package com.br.base_template.controller;

import com.br.base_template.model.ATM;
import com.br.base_template.service.ATMService;
import com.br.base_template.dto.RequestHeaderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class ATMController {

    @Autowired
    private ATMService atmService;

    @GetMapping("/automated-teller-machines/")
    public ResponseEntity<List<ATM>> getAllATMs(RequestHeaderDto headers) {
        List<ATM> atms = atmService.getAllATMs();
        return ResponseEntity.ok(atms);
    }

    @GetMapping("/automated-teller-machines/{id}")
    public ResponseEntity<ATM> getATMByIdentifier(@PathVariable String id, RequestHeaderDto headers) {
        Optional<ATM> atm = atmService.getATMByIdentifier(id);
        return atm.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}