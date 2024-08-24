package com.unig4telco.grecio.diogo.Backend.crm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.unig4telco.grecio.diogo.Backend.crm.domain.Tecnologia;
import com.unig4telco.grecio.diogo.Backend.crm.repositories.TecnologiaRepository;

@Service
public class TecnologiaService {
    @Autowired
    private TecnologiaRepository tecnologiaRepository;
    
    public List<Tecnologia> findAll() {
        return tecnologiaRepository.findAll();
    }

    // public List<Tecnologia> tipoFacturacao(String tipoFacturacao) {
    //     return tecnologiaRepository.findByTipoFacturacao(tipoFacturacao);
    // }
}
