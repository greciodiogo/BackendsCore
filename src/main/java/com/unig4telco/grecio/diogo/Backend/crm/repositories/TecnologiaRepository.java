package com.unig4telco.grecio.diogo.Backend.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.unig4telco.grecio.diogo.Backend.crm.domain.Tecnologia;

public interface TecnologiaRepository extends JpaRepository <Tecnologia, Long>{
    List<Tecnologia> findAll();

    List<Tecnologia> findByTipoFacturacao(String tipoFacturacao);
}
