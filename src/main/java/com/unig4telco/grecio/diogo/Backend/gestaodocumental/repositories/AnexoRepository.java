package com.unig4telco.grecio.diogo.Backend.gestaodocumental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unig4telco.grecio.diogo.Backend.gestaodocumental.domain.Anexo;

import java.util.List;

public interface AnexoRepository extends JpaRepository<Anexo, Long> {
    List<Anexo> findAll();
}
