package com.unig4telco.grecio.diogo.Backend.configs.tecnologia._services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.unig4telco.grecio.diogo.Backend.configs.tecnologia._domain.Tecnologia;
import com.unig4telco.grecio.diogo.Backend.configs.tecnologia._repositories.TecnologiaRepository;
import com.unig4telco.grecio.diogo.Backend.crm.DTO.TecnologiaDTO;

@Service
public class TecnologiaService {
    @Autowired
    private TecnologiaRepository tecnologiaRepository;
    
    public Page<TecnologiaDTO> findAll() {
        
        Pageable pageable = PageRequest.of(1, 5);
         Specification<Tecnologia> spec = Specification.where(null);

            Page<Tecnologia> data = tecnologiaRepository.findAll(spec, pageable);

        return data.map(TecnologiaDTO::new);
    }

    public Page<TecnologiaDTO> findByTipoFacturacao(String tipoFacturacao) {
        Pageable pageable = PageRequest.of(1, 5);
        Specification<Tecnologia> spec = Specification.where(null);

           Page<Tecnologia> data = tecnologiaRepository.findByTipoFacturacao(spec, pageable, tipoFacturacao);

       return data.map(TecnologiaDTO::new);
    }
}
