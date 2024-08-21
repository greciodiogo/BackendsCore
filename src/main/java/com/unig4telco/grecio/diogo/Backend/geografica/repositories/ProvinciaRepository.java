package com.unig4telco.grecio.diogo.Backend.geografica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.unig4telco.grecio.diogo.Backend.geografica.domain.Provincia;

public interface ProvinciaRepository extends JpaRepository<Provincia, Long>{
        List<Provincia> findAll();
}
