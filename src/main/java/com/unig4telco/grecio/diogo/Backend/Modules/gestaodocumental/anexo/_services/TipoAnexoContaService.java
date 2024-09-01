package com.unig4telco.grecio.diogo.Backend.Modules.gestaodocumental.anexo._services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.contas._repositories.TipoAnexoConta;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.contas.tipoAnexoListar.DTO.TipoAnexoContaDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.gestaodocumental.anexo._repositories.TipoAnexoContaRepository;

@Service
public class TipoAnexoContaService {

    private final TipoAnexoContaRepository tipoanexocontaRepository;

    public TipoAnexoContaService(TipoAnexoContaRepository tipoanexocontaRepository) {
        this.tipoanexocontaRepository = tipoanexocontaRepository;
    }

    public Page<TipoAnexoContaDTO> findAll() {
        Pageable pageable = PageRequest.of(0, 5);
        Specification<TipoAnexoConta> spec = Specification.where(null);
        Page<TipoAnexoConta> data = tipoanexocontaRepository.findAll(spec, pageable);

        return data.map(TipoAnexoContaDTO::new);
    }
}
