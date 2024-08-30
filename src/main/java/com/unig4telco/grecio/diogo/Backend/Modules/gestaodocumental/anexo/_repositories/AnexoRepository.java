package com.unig4telco.grecio.diogo.Backend.Modules.gestaodocumental.anexo._repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.unig4telco.grecio.diogo.Backend.Modules.gestaodocumental.anexo._domain.Anexo;


public interface AnexoRepository extends JpaRepository<Anexo, Long>, JpaSpecificationExecutor<Anexo> {}
