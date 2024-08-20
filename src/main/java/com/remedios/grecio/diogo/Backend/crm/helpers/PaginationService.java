package com.remedios.grecio.diogo.Backend.crm.helpers;

import com.remedios.grecio.diogo.Backend.crm.domain.Clientes;
import com.remedios.grecio.diogo.Backend.crm.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaginationService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Clientes> getClientes() {
        return clienteRepository.findAll();
    }

    public List<Clientes> getClientesWithSorting(String field){
        return  clienteRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    public Page<Clientes> getClientesWithPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return clienteRepository.findAll(pageable);
    }

    public Page<Clientes> getClientesWithPaginationAndSorting(int pageNo, int pageSize, String field) {
        Pageable pageable = PageRequest.of(pageNo, pageSize).withSort(Sort.by(field));
        return clienteRepository.findAll(pageable);
    }
}
