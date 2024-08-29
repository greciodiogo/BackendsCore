package com.unig4telco.grecio.diogo.Backend.crm.repositories;

import com.unig4telco.grecio.diogo.Backend.crm.domain.EstadoCivil;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EstadoCivilRepository extends JpaRepository<EstadoCivil, Long>, JpaSpecificationExecutor<EstadoCivil>{
}

