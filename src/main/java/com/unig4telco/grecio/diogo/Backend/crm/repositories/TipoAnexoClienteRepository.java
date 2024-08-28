package com.unig4telco.grecio.diogo.Backend.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.unig4telco.grecio.diogo.Backend.crm.domain.TipoAnexoCliente;

public interface TipoAnexoClienteRepository extends JpaRepository<TipoAnexoCliente, Long>, JpaSpecificationExecutor<TipoAnexoCliente> {

}
