package com.unig4telco.grecio.diogo.Backend.geografica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.unig4telco.grecio.diogo.Backend.geografica.domain.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long>{
   List<Pais> findAll();
}

