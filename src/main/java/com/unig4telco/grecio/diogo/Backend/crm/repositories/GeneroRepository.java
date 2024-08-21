package com.unig4telco.grecio.diogo.Backend.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.unig4telco.grecio.diogo.Backend.crm.domain.Generos;

public interface GeneroRepository extends JpaRepository<Generos, Long>{
    List<Generos> findAll();
}
