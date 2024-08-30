package com.unig4telco.grecio.diogo.Backend.configs.direccao._services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.unig4telco.grecio.diogo.Backend.configs.direccao._domain.DireccaoArea;
import com.unig4telco.grecio.diogo.Backend.configs.direccao._repositories.DireccaoAreaRepository;
import com.unig4telco.grecio.diogo.Backend.configs.direccao.direccaoAreaListar.DTO.DireccaoAreaDTO;

@Service
public class DireccaoAreaService {

    private final DireccaoAreaRepository direccaoareaRepository;

    public DireccaoAreaService(DireccaoAreaRepository direccaoareaRepository) {
        this.direccaoareaRepository = direccaoareaRepository;
    }

        public Page<DireccaoAreaDTO> findAll() {
        Pageable pageable = PageRequest.of(1, 5);
        Specification<DireccaoArea> spec = Specification.where(null);
        Page<DireccaoArea> data = direccaoareaRepository.findAll(spec, pageable);

        return data.map(DireccaoAreaDTO::new);
    }
}
