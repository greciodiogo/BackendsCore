package com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.nacionalidade.tipoNacionalidadeListar.DTO;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.nacionalidade._repositories.TipoNacionalidade;

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
