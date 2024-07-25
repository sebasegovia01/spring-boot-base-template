package com.br.base_template.controller;

import com.br.base_template.model.ATM;
import com.br.base_template.service.ATMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ATMController {

    @Autowired
    private ATMService atmService;

    /**
     * Get all ATMs
     * @return List of all ATMs
     */
    @GetMapping("/automated-teller-machines")
    public ResponseEntity<List<ATM>> getAllATMs() {
        List<ATM> atms = atmService.getAllATMs();
        return ResponseEntity.ok(atms);
    }

    /**
     * Get an ATM by its identifier
     * @param id the identifier of the ATM
     * @return ResponseEntity with ATM if found, else not found status
     */
    @GetMapping("/automated-teller-machines/{id}")
    public ResponseEntity<ATM> getATMByIdentifier(@PathVariable String id) {
        Optional<ATM> atm = atmService.getATMByIdentifier(id);
        return atm.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
