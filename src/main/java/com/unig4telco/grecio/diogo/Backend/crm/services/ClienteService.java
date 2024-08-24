package com.unig4telco.grecio.diogo.Backend.crm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.unig4telco.grecio.diogo.Backend.crm.DTO.ListClientesDTO;
import com.unig4telco.grecio.diogo.Backend.crm.repositories.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
        
        public Page<ListClientesDTO> findAll(int pageNo, int pageSize) {
            Pageable pageable = PageRequest.of(pageNo, pageSize).withSort(Sort.Direction.DESC, "createdAt");
            var data = clienteRepository.findAll(pageable);
        return data.map(ListClientesDTO::new);
    }

}
