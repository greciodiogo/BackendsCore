package com.unig4telco.grecio.diogo.Backend.crm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.unig4telco.grecio.diogo.Backend.crm.domain.TipoNacionalidade;

public interface TipoNacionalidadeRepository extends JpaRepository<TipoNacionalidade, Long>{
    List<TipoNacionalidade> findAll();
}
