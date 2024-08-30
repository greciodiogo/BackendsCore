package com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.estadoCivil._repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.estadoCivil._domain.EstadoCivil;

public interface EstadoCivilRepository extends JpaRepository<EstadoCivil, Long>, JpaSpecificationExecutor<EstadoCivil>{
}

