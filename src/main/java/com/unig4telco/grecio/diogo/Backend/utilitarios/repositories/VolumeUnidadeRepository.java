package com.unig4telco.grecio.diogo.Backend.utilitarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.unig4telco.grecio.diogo.Backend.utilitarios.domain.VolumeUnidade;

public interface VolumeUnidadeRepository extends JpaRepository<VolumeUnidade, Long>, JpaSpecificationExecutor<VolumeUnidade>{

}
