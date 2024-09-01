package com.unig4telco.grecio.diogo.Backend.Modules.configs.tecnologia._services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.unig4telco.grecio.diogo.Backend.Modules.configs.tecnologia._domain.Tecnologia;
import com.unig4telco.grecio.diogo.Backend.Modules.configs.tecnologia._repositories.TecnologiaRepository;
import com.unig4telco.grecio.diogo.Backend.Modules.configs.tecnologia.tecnologiaListar.DTO.TecnologiaDTO;

@Service
public class TecnologiaService {
    @Autowired
    private TecnologiaRepository tecnologiaRepository;
    
    public Page<TecnologiaDTO> findAll() {
        
        Pageable pageable = PageRequest.of(0, 5);
         Specification<Tecnologia> spec = Specification.where(null);

            Page<Tecnologia> data = tecnologiaRepository.findAll(spec, pageable);

        return data.map(TecnologiaDTO::new);
    }

    public List<TecnologiaDTO> findByTipoFacturacao(String tipoFacturacao) {
        Specification<Tecnologia> spec = Specification.where(null);
        if (tipoFacturacao != null && tipoFacturacao.isEmpty()) {
            spec = spec.and(
                    (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("tipoFacturacao"), tipoFacturacao));
        }
           List<TecnologiaDTO> data = tecnologiaRepository.findAll(spec).stream()
                  .map(TecnologiaDTO::new)
                .toList();

       return data;
    }
}
