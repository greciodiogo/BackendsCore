package com.unig4telco.grecio.diogo.Backend.crm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unig4telco.grecio.diogo.Backend.crm.domain.TipoIdentidade;

public interface TipoIdentidadeRepository extends JpaRepository<TipoIdentidade, Long> {
    List<TipoIdentidade> findAll();   
}

