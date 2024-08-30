package com.unig4telco.grecio.diogo.Backend.configs.direccao._repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.unig4telco.grecio.diogo.Backend.configs.direccao._domain.Direccao;

public interface DireccaoRepository extends JpaRepository<Direccao, Long>, JpaSpecificationExecutor<Direccao>{} 
