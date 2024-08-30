package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._domain.EntidadeCativadora;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._repositories.EntidadeCativadoraRepository;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.entidadeCativadorasListar.DTO.EntidadeCativadoraDTO;

@Service
public class EntidadeCativadoraService {
    @Autowired
    private EntidadeCativadoraRepository entidadeCativadoraRepository;

     public Page<EntidadeCativadoraDTO> findAll() {
        Pageable pageable = PageRequest.of(0, 5);
        Specification<EntidadeCativadora> spec = Specification.where(null);
        Page<EntidadeCativadora> data = entidadeCativadoraRepository.findAll(spec, pageable);

        return data.map(EntidadeCativadoraDTO::new);
    }
}
