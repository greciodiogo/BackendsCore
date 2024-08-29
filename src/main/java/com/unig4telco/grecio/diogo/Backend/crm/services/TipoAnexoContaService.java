package com.unig4telco.grecio.diogo.Backend.crm.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.unig4telco.grecio.diogo.Backend.crm.DTO.TipoAnexoContaDTO;
import com.unig4telco.grecio.diogo.Backend.crm.domain.TipoAnexoConta;
import com.unig4telco.grecio.diogo.Backend.crm.repositories.TipoAnexoContaRepository;

@Service
public class TipoAnexoContaService {

    private final TipoAnexoContaRepository tipoanexocontaRepository;

    public TipoAnexoContaService(TipoAnexoContaRepository tipoanexocontaRepository) {
        this.tipoanexocontaRepository = tipoanexocontaRepository;
    }

    public Page<TipoAnexoContaDTO> findAll() {
        Pageable pageable = PageRequest.of(1, 5);
        Specification<TipoAnexoConta> spec = Specification.where(null);
        Page<TipoAnexoConta> data = tipoanexocontaRepository.findAll(spec, pageable);

        return data.map(TipoAnexoContaDTO::new);
    }
}
