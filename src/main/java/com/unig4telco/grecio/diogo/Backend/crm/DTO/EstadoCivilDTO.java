package com.unig4telco.grecio.diogo.Backend.crm.DTO;

import com.unig4telco.grecio.diogo.Backend.crm.domain.EstadoCivil;

public record EstadoCivilDTO(
    Integer id, 
    String nome,
    String slug
) {
    public EstadoCivilDTO(EstadoCivil estadoCivil){
        this(
            estadoCivil.getId(),
            estadoCivil.getNome(),
            estadoCivil.getSlug()
        );
    }
}
