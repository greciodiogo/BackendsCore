package com.unig4telco.grecio.diogo.Backend.crm.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.unig4telco.grecio.diogo.Backend.crm.DTO.TipoContaDTO;
import com.unig4telco.grecio.diogo.Backend.crm.domain.TipoConta;
import com.unig4telco.grecio.diogo.Backend.crm.repositories.TipoContaRepository;

@Service
public class TipoContaService {

    private final TipoContaRepository tipocontaRepository;

    public TipoContaService(TipoContaRepository tipocontaRepository) {
        this.tipocontaRepository = tipocontaRepository;
    }

    public Page<TipoContaDTO> findAll() {
        Pageable pageable = PageRequest.of(1, 5);
        Specification<TipoConta> spec = Specification.where(null);
        Page<TipoConta> data = tipocontaRepository.findAll(spec, pageable);

        return data.map(TipoContaDTO::new);
    }
}
