package com.unig4telco.grecio.diogo.Backend.Modules.geografica.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.unig4telco.grecio.diogo.Backend.Modules.geografica.domain.Pais;

import java.util.List;

public interface PaisRepository extends JpaRepository<Pais, Long>{
   List<Pais> findAll();
}

