package com.unig4telco.grecio.diogo.Backend.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unig4telco.grecio.diogo.Backend.crm.domain.Clientes;

public interface ClienteRepository extends JpaRepository<Clientes, Long> {
     // Page<Clientes> findAll(PageRequest pageRequest);
}
