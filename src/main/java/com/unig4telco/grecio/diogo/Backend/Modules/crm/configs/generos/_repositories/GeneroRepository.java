package com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.generos._repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.generos._domain.Generos;

public interface GeneroRepository extends JpaRepository<Generos, Long>, JpaSpecificationExecutor<Generos>{}
