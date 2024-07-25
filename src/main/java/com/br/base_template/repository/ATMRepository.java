package com.br.base_template.repository;

import com.br.base_template.model.ATM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ATMRepository extends JpaRepository<ATM, Long> {
    Optional<ATM> findByAtmIdentifier(String atmIdentifier);
}
