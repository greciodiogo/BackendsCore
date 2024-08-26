package com.unig4telco.grecio.diogo.Backend.crm.services;

import org.springframework.stereotype.Service;
import java.util.List;
import com.unig4telco.grecio.diogo.Backend.crm.domain.Estatuto;
import com.unig4telco.grecio.diogo.Backend.crm.repositories.EstatutoRepository;

@Service
public class EstatutoService {

    private final EstatutoRepository estatutoRepository;

    public EstatutoService(EstatutoRepository estatutoRepository) {
        this.estatutoRepository = estatutoRepository;
    }

    public List<Estatuto> findAll() {
        return estatutoRepository.findAll();
    }
}
