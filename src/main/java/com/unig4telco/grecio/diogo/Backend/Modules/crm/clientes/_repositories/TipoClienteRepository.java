package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._domain.TipoCliente;

public interface TipoClienteRepository extends JpaRepository<TipoCliente, Long>, JpaSpecificationExecutor<TipoCliente>{
    List<TipoCliente> findBySlug(String slug);
}
