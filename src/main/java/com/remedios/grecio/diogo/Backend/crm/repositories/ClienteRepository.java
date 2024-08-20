package com.remedios.grecio.diogo.Backend.crm.repositories;

import com.remedios.grecio.diogo.Backend.crm.domain.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Clientes, Long> {

    List<Clientes> findAll();
}
