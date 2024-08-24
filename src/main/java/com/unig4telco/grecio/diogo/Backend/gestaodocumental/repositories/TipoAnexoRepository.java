package com.unig4telco.grecio.diogo.Backend.gestaodocumental.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unig4telco.grecio.diogo.Backend.gestaodocumental.domain.TipoAnexo;

public interface TipoAnexoRepository extends JpaRepository<TipoAnexo, Long> {
    List<TipoAnexo> findAll();

    List<TipoAnexo> findByTipoBancarioTrue();
}
