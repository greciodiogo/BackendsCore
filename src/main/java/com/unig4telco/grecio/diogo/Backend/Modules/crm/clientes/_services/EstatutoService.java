package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._domain.Estatuto;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._repositories.EstatutoRepository;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.clienteEstatutoListar.DTO.EstatutoDTO;

@Service
public class EstatutoService {

    private final EstatutoRepository estatutoRepository;

    public EstatutoService(EstatutoRepository estatutoRepository) {
        this.estatutoRepository = estatutoRepository;
    }

     public Page<EstatutoDTO> findAll() {
        Pageable pageable = PageRequest.of(1, 5);
        Specification<Estatuto> spec = Specification.where(null);
        Page<Estatuto> data = estatutoRepository.findAll(spec, pageable);

        return data.map(EstatutoDTO::new);
    }
}
