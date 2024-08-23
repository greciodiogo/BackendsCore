package com.unig4telco.grecio.diogo.Backend.utilitarios.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unig4telco.grecio.diogo.Backend.utilitarios.domain.VolumeUnidade;

public interface VolumeUnidadeRepository extends JpaRepository<VolumeUnidade, Long>{
    List<VolumeUnidade> findAll();
}
