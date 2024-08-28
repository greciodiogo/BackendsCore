package com.unig4telco.grecio.diogo.Backend.utilitarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.unig4telco.grecio.diogo.Backend.utilitarios.domain.Documento;

public interface DocumentoRepository extends JpaRepository <Documento, Long>, JpaSpecificationExecutor<Documento>{

}
