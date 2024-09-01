package com.unig4telco.grecio.diogo.Backend.Modules.gestaodocumental.anexo._services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._domain.TipoAnexoCliente;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.tipoAnexoClienteListar.DTO.TipoAnexoClienteDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.gestaodocumental.anexo._repositories.TipoAnexoClienteRepository;

@Service
public class TipoAnexoClienteService {

    private final TipoAnexoClienteRepository tipoanexoclienteRepository;

    public TipoAnexoClienteService(TipoAnexoClienteRepository tipoanexoclienteRepository) {
        this.tipoanexoclienteRepository = tipoanexoclienteRepository;
    }
    public Page<TipoAnexoClienteDTO> findAll() {
        Pageable pageable = PageRequest.of(0, 5);
        Specification<TipoAnexoCliente> spec = Specification.where(null);
        Page<TipoAnexoCliente> data = tipoanexoclienteRepository.findAll(spec, pageable);

        return data.map(TipoAnexoClienteDTO::new);
    }
}
