package com.unig4telco.grecio.diogo.Backend.crm.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.unig4telco.grecio.diogo.Backend.crm.DTO.PropostaDTO;
import com.unig4telco.grecio.diogo.Backend.crm.domain.Proposta;
import com.unig4telco.grecio.diogo.Backend.crm.repositories.PropostaRepository;

@Service
public class PropostaService {

    private final PropostaRepository propostaRepository;

    public PropostaService(PropostaRepository propostaRepository) {
        this.propostaRepository = propostaRepository;
    }

     public Page<PropostaDTO> findAll() {
        Pageable pageable = PageRequest.of(1, 5);
        Specification<Proposta> spec = Specification.where(null);
        Page<Proposta> data = propostaRepository.findAll(spec, pageable);

        return data.map(PropostaDTO::new);
    }
}
