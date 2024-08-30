package com.unig4telco.grecio.diogo.Backend.Modules.crm.contas._services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.contas._domain.TipoConta;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.contas._repositories.TipoContaRepository;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.contas.tipoContaListar.DTO.TipoContaDTO;

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
