package com.unig4telco.grecio.diogo.Backend.crm.services;

import org.springframework.stereotype.Service;
import java.util.List;
import com.unig4telco.grecio.diogo.Backend.crm.domain.Conta;
import com.unig4telco.grecio.diogo.Backend.crm.repositories.ContaRepository;

@Service
public class ContaService {

    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public List<Conta> findAll() {
        return contaRepository.findAll();
    }
}
