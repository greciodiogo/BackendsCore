package com.unig4telco.grecio.diogo.Backend.utilitarios.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unig4telco.grecio.diogo.Backend.utilitarios.domain.Moeda;

public interface MoedaRepository extends JpaRepository<Moeda, Long>{
    List<Moeda> findAll();
}
