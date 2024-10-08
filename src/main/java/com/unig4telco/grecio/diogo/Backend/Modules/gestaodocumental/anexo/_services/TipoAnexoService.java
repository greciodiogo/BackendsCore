package com.unig4telco.grecio.diogo.Backend.Modules.gestaodocumental.anexo._services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.unig4telco.grecio.diogo.Backend.Modules.gestaodocumental.anexo._domain.TipoAnexo;
import com.unig4telco.grecio.diogo.Backend.Modules.gestaodocumental.anexo._repositories.TipoAnexoRepository;

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

    public List<TipoAnexo> findByArea(String area) {
        return tipoAnexoRepository.findByArea(area);
    }
}