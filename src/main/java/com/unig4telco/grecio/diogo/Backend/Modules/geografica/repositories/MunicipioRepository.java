package com.unig4telco.grecio.diogo.Backend.Modules.geografica.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.unig4telco.grecio.diogo.Backend.Modules.geografica.domain.Municipio;

import java.util.List;

public interface MunicipioRepository extends JpaRepository<Municipio, Long>{
        List<Municipio> findAll();

        List<Municipio> findByProvinciaId(Integer provinciaId);
}
