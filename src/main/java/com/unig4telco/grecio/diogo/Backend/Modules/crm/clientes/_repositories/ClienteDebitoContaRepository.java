package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._domain.ClienteContaDebito;

public interface ClienteDebitoContaRepository extends JpaRepository<ClienteContaDebito, Integer>, JpaSpecificationExecutor<ClienteContaDebito>{
    
}
