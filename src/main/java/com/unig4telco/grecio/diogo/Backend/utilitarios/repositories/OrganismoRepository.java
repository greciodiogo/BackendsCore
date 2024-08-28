package com.unig4telco.grecio.diogo.Backend.utilitarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.unig4telco.grecio.diogo.Backend.utilitarios.domain.Organismo;

public interface OrganismoRepository extends JpaRepository<Organismo, Long>, JpaSpecificationExecutor<Organismo>{

}
