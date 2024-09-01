package com.unig4telco.grecio.diogo.Backend.Modules.configs.tecnologia._repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.unig4telco.grecio.diogo.Backend.Modules.configs.tecnologia._domain.Tecnologia;

public interface TecnologiaRepository extends JpaRepository <Tecnologia, Long>, JpaSpecificationExecutor<Tecnologia>{
}
