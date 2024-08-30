package com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.identidade.tipoIdentidadeListar.DTO;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.identidade._domain.TipoIdentidade;

public record TipoIdentidadeDTO(
    Integer id, 
    String nome,
    String slug,
    String regex
) {
    public TipoIdentidadeDTO(TipoIdentidade tipoIdentidade){
        this(
            tipoIdentidade.getId(),
            tipoIdentidade.getNome(),
            tipoIdentidade.getSlug(),
            tipoIdentidade.getRegex()
        );
    }
}
