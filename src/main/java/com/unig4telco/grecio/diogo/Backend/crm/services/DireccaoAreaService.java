package com.unig4telco.grecio.diogo.Backend.crm.services;

import org.springframework.stereotype.Service;
import java.util.List;
import com.unig4telco.grecio.diogo.Backend.crm.domain.DireccaoArea;
import com.unig4telco.grecio.diogo.Backend.crm.repositories.DireccaoAreaRepository;

@Service
public class DireccaoAreaService {

    private final DireccaoAreaRepository direccaoareaRepository;

    public DireccaoAreaService(DireccaoAreaRepository direccaoareaRepository) {
        this.direccaoareaRepository = direccaoareaRepository;
    }

    public List<DireccaoArea> findAll() {
        return direccaoareaRepository.findAll();
    }
}
