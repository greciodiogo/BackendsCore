package com.unig4telco.grecio.diogo.Backend.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unig4telco.grecio.diogo.Backend.crm.domain.Clientes;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Clientes, Long> {

    List<Clientes> findAll();
}
