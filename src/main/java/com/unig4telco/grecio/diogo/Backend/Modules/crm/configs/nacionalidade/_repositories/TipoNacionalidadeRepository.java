package com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.nacionalidade._repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TipoNacionalidadeRepository extends JpaRepository<TipoNacionalidade, Long>, JpaSpecificationExecutor<TipoNacionalidade>{
}
