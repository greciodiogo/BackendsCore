package com.unig4telco.grecio.diogo.Backend.Modules.gestaodocumental.anexo._repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.unig4telco.grecio.diogo.Backend.Modules.gestaodocumental.anexo._domain.TipoAnexo;

public interface TipoAnexoRepository extends JpaRepository<TipoAnexo, Long>, JpaSpecificationExecutor<TipoAnexo> {
    List<TipoAnexo> findByTipoBancarioTrue();

    List<TipoAnexo> findByArea(String area);
}
