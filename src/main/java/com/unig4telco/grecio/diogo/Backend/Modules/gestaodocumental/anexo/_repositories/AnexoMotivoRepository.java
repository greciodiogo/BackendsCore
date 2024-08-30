package com.unig4telco.grecio.diogo.Backend.Modules.gestaodocumental.anexo._repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.unig4telco.grecio.diogo.Backend.Modules.gestaodocumental.anexo._domain.AnexoMotivo;


public interface AnexoMotivoRepository extends JpaRepository<AnexoMotivo, Long>, JpaSpecificationExecutor<AnexoMotivo> {
}
