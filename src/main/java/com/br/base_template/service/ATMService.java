package com.br.base_template.service;

import com.br.base_template.model.ATM;
import com.br.base_template.repository.ATMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ATMService {

    @Autowired
    private ATMRepository atmRepository;

    /**
     * Get all ATMs
     * @return List of all ATMs
     */
    public List<ATM> getAllATMs() {
        return atmRepository.findAll();
    }

    /**
     * Get an ATM by its identifier
     * @param atmIdentifier the identifier of the ATM
     * @return Optional of ATM
     */
    public Optional<ATM> getATMByIdentifier(String atmIdentifier) {
        return atmRepository.findByAtmIdentifier(atmIdentifier);
    }
}
