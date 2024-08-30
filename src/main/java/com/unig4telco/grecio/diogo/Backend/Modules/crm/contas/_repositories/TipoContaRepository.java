package com.unig4telco.grecio.diogo.Backend.Modules.crm.contas._repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.contas._domain.TipoConta;

public interface TipoContaRepository extends JpaRepository<TipoConta, Long>, JpaSpecificationExecutor<TipoConta> {}
