package com.unig4telco.grecio.diogo.Backend.crm.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unig4telco.grecio.diogo.Backend.crm.domain.TipoCliente;

public interface TipoClienteRepository extends JpaRepository<TipoCliente, Long>{
    List<TipoCliente> findAll();

     Optional<TipoCliente> findBySlug(String slug);
    
}
