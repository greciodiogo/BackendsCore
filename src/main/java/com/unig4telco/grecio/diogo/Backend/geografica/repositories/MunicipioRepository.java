package com.unig4telco.grecio.diogo.Backend.geografica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.unig4telco.grecio.diogo.Backend.geografica.domain.Municipio;

public interface MunicipioRepository extends JpaRepository<Municipio, Long>{
        List<Municipio> findAll();

        List<Municipio> findByProvinciaId(Integer provinciaId);
}
