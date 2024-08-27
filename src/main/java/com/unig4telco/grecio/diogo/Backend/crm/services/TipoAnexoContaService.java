package com.unig4telco.grecio.diogo.Backend.crm.services;

import org.springframework.stereotype.Service;
import java.util.List;
import com.unig4telco.grecio.diogo.Backend.crm.domain.TipoAnexoConta;
import com.unig4telco.grecio.diogo.Backend.crm.repositories.TipoAnexoContaRepository;

@Service
public class TipoAnexoContaService {

    private final TipoAnexoContaRepository tipoanexocontaRepository;

    public TipoAnexoContaService(TipoAnexoContaRepository tipoanexocontaRepository) {
        this.tipoanexocontaRepository = tipoanexocontaRepository;
    }

    public List<TipoAnexoConta> findAll() {
        return tipoanexocontaRepository.findAll();
    }
}
