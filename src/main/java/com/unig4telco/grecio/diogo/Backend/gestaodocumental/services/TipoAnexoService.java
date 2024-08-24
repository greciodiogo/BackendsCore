package com.unig4telco.grecio.diogo.Backend.gestaodocumental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.unig4telco.grecio.diogo.Backend.gestaodocumental.domain.TipoAnexo;
import com.unig4telco.grecio.diogo.Backend.gestaodocumental.repositories.TipoAnexoRepository;

@Service
public class TipoAnexoService {

    @Autowired
    private TipoAnexoRepository tipoAnexoRepository;

    public List<TipoAnexo> findAll() {
        return tipoAnexoRepository.findAll();
    }

    public List<TipoAnexo> typeAnexoBancario() {
        return tipoAnexoRepository.findByTipoBancarioTrue();
    }
}