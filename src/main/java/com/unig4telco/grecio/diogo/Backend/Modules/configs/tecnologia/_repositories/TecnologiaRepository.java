package com.unig4telco.grecio.diogo.Backend.Modules.configs.tecnologia._repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.unig4telco.grecio.diogo.Backend.Modules.configs.tecnologia._domain.Tecnologia;

public interface TecnologiaRepository extends JpaRepository <Tecnologia, Long>, JpaSpecificationExecutor<Tecnologia>{

    Page<Tecnologia> findByTipoFacturacao(Specification<Tecnologia> spec, Pageable pageable, String tipoFacturacao);
}
