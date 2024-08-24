package com.unig4telco.grecio.diogo.Backend.gestaodocumental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unig4telco.grecio.diogo.Backend.gestaodocumental.domain.AnexoMotivo;

import java.util.List;

public interface AnexoMotivoRepository extends JpaRepository<AnexoMotivo, Long> {
    List<AnexoMotivo> findAll();
}
