package com.unig4telco.grecio.diogo.Backend.Modules.utilitarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.unig4telco.grecio.diogo.Backend.Modules.utilitarios.domain.Bancos;

public interface BancosRepository extends JpaRepository<Bancos, Long>, JpaSpecificationExecutor<Bancos>{

}
