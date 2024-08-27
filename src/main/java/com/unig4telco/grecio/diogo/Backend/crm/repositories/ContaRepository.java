package com.unig4telco.grecio.diogo.Backend.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.unig4telco.grecio.diogo.Backend.crm.domain.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    List<Conta> findAll();
}
