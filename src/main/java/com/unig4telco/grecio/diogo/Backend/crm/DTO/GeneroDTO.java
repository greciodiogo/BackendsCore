package com.unig4telco.grecio.diogo.Backend.crm.DTO;

import com.unig4telco.grecio.diogo.Backend.crm.domain.Generos;

public record GeneroDTO(
    Integer id, 
    String descricao,
    String abreviacao,
    String slug
) {
    public GeneroDTO(Generos generos){
        this(
            generos.getId(),
            generos.getDescricao(),
            generos.getAbreviacao(),
            generos.getSlug()
        );
    }
}
