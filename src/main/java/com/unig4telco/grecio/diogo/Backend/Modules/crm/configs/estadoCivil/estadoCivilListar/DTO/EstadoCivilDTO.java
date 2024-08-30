package com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.estadoCivil.estadoCivilListar.DTO;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.estadoCivil._domain.EstadoCivil;

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
