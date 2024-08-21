package com.unig4telco.grecio.diogo.Backend.crm.repositories;

import com.unig4telco.grecio.diogo.Backend.crm.domain.EstadoCivil;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoCivilRepository extends JpaRepository<EstadoCivil, Long>{
    List<EstadoCivil> findAll();
}

