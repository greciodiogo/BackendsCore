package com.unig4telco.grecio.diogo.Backend.crm.services;

import org.springframework.stereotype.Service;
import java.util.List;
import com.unig4telco.grecio.diogo.Backend.crm.domain.TipoAnexoCliente;
import com.unig4telco.grecio.diogo.Backend.crm.repositories.TipoAnexoClienteRepository;

@Service
public class TipoAnexoClienteService {

    private final TipoAnexoClienteRepository tipoanexoclienteRepository;

    public TipoAnexoClienteService(TipoAnexoClienteRepository tipoanexoclienteRepository) {
        this.tipoanexoclienteRepository = tipoanexoclienteRepository;
    }

    public List<TipoAnexoCliente> findAll() {
        return tipoanexoclienteRepository.findAll();
    }
}
