package com.unig4telco.grecio.diogo.Backend.crm.DTO;

import com.unig4telco.grecio.diogo.Backend.crm.domain.Identidade;

public record IdentidadeDTO(
    Integer id, 
    String numero_identidade,
    Integer tipoIdentidade_id,
    TipoIdentidadeDTO tipoIdentidade
) {
    public IdentidadeDTO(Identidade identidade){
        this(
            identidade.getId(),
            identidade.getNumero_identidade(),
            identidade.getTipoIdentidade() != null ? identidade.getTipoIdentidade().getId() : null,
            identidade.getTipoIdentidade() != null ? new TipoIdentidadeDTO(identidade.getTipoIdentidade()) : null
        );
    }
}

