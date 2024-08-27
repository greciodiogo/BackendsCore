package com.unig4telco.grecio.diogo.Backend.crm.services;

import org.springframework.stereotype.Service;
import java.util.List;
import com.unig4telco.grecio.diogo.Backend.crm.domain.TipoConta;
import com.unig4telco.grecio.diogo.Backend.crm.repositories.TipoContaRepository;

@Service
public class TipoContaService {

    private final TipoContaRepository tipocontaRepository;

    public TipoContaService(TipoContaRepository tipocontaRepository) {
        this.tipocontaRepository = tipocontaRepository;
    }

    public List<TipoConta> findAll() {
        return tipocontaRepository.findAll();
    }
}
