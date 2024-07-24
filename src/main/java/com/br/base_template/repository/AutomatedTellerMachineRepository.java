package com.br.base_template.repository;

import com.br.base_template.model.AutomatedTellerMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AutomatedTellerMachineRepository extends JpaRepository<AutomatedTellerMachine, Long> {
    Optional<AutomatedTellerMachine> findByAtmIdentifier(String atmIdentifier);
}
