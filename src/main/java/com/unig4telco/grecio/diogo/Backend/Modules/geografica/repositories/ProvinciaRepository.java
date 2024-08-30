package com.unig4telco.grecio.diogo.Backend.Modules.geografica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unig4telco.grecio.diogo.Backend.Modules.geografica.domain.Provincia;

import java.util.List;

public interface ProvinciaRepository extends JpaRepository<Provincia, Long>{
        List<Provincia> findAll();

        List<Provincia> findByPaisId(Integer pais_id);

}
