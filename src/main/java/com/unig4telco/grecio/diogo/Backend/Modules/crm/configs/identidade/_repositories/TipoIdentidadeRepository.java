package com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.identidade._repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.identidade._domain.TipoIdentidade;

public interface TipoIdentidadeRepository extends JpaRepository<TipoIdentidade, Long>, JpaSpecificationExecutor<TipoIdentidade> {

}

