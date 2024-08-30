package com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.identidade.identidadeListar.DTO;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.identidade._domain.Identidade;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.identidade.tipoIdentidadeListar.DTO.TipoIdentidadeDTO;

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

