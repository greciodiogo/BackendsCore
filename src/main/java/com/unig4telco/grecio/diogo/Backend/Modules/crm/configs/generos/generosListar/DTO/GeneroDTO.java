package com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.generos.generosListar.DTO;

import java.util.Date;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.generos._domain.Generos;

public record GeneroDTO(
    Integer id, 
    String descricao,
    String abreviacao,
    String slug,
    Boolean is_actived,
    Boolean is_deleted,
    Date created_at,
    Date updated_at
) {
    public GeneroDTO(Generos generos){
        this(
            generos.getId(),
            generos.getDescricao(),
            generos.getAbreviacao(),
            generos.getSlug(),
            generos.getIs_actived(),
            generos.getIs_deleted(),
            generos.getCreatedAt(),
            generos.getUpdatedAt()
        );
    }
}
