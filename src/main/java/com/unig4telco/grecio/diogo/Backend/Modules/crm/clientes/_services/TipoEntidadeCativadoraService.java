package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._domain.TipoEntidadeCativadora;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._repositories.TipoEntidadeCativadoraRepository;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.tipoEntidadeCativadorasListar.DTO.TipoEntidadeCativadoraDTO;

@Service
public class TipoEntidadeCativadoraService {
       @Autowired
    private TipoEntidadeCativadoraRepository tipoEntidadeCativadoraRepository;

     public Page<TipoEntidadeCativadoraDTO> findAll() {
        Pageable pageable = PageRequest.of(0, 5);
        Specification<TipoEntidadeCativadora> spec = Specification.where(null);
        Page<TipoEntidadeCativadora> data = tipoEntidadeCativadoraRepository.findAll(spec, pageable);

        return data.map(TipoEntidadeCativadoraDTO::new);
    }
}
