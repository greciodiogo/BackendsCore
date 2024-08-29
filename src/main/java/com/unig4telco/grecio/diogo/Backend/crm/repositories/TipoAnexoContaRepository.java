package com.unig4telco.grecio.diogo.Backend.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.unig4telco.grecio.diogo.Backend.crm.domain.TipoAnexoConta;

public interface TipoAnexoContaRepository extends JpaRepository<TipoAnexoConta, Long>, JpaSpecificationExecutor<TipoAnexoConta> {}
