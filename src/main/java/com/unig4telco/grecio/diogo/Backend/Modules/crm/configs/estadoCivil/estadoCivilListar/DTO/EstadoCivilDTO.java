package com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.estadoCivil.estadoCivilListar.DTO;

import java.util.Date;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.estadoCivil._domain.EstadoCivil;

public record EstadoCivilDTO(
    Integer id, 
    String nome,
    String slug,
    Boolean is_actived,
    Boolean is_deleted,
    Date created_at,
    Date updated_at
) {
    public EstadoCivilDTO(EstadoCivil estadoCivil){
        this(
            estadoCivil.getId(),
            estadoCivil.getNome(),
            estadoCivil.getSlug(),
            estadoCivil.getIs_actived(),
            estadoCivil.getIs_deleted(),
            estadoCivil.getCreatedAt(),
            estadoCivil.getUpdatedAt()
        );
    }
}
