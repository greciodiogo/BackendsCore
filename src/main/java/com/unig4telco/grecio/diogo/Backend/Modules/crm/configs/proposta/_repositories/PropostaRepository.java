package com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.proposta._repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.proposta._domain.Proposta;

public interface PropostaRepository extends JpaRepository<Proposta, Long>, JpaSpecificationExecutor<Proposta> {}
