package com.unig4telco.grecio.diogo.Backend.crm.DTO;

import com.unig4telco.grecio.diogo.Backend.crm.domain.TipoNacionalidade;

public record TipoNacionalidadeDTO(
    Integer id, 
    String nome,
    String slug
) {
    public TipoNacionalidadeDTO(TipoNacionalidade tipoNacionalidade){
        this(
            tipoNacionalidade.getId(),
            tipoNacionalidade.getNome(),
            tipoNacionalidade.getSlug()
        );
    }
}
