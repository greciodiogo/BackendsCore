package com.unig4telco.grecio.diogo.Backend.Modules.crm.contas._services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.contas._domain.Conta;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.contas._repositories.ContaRepository;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.contas.contaListar.DTO.ContaDTO;

@Service
public class ContaService {

    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public Page<ContaDTO> findAll() {
        Pageable pageable = PageRequest.of(1, 5);
        Specification<Conta> spec = Specification.where(null);
        Page<Conta> data = contaRepository.findAll(spec, pageable);

        return data.map(ContaDTO::new);
    }
}
