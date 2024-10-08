package com.unig4telco.grecio.diogo.Backend.Modules.utilitarios.DTO;

import com.unig4telco.grecio.diogo.Backend.Modules.utilitarios.domain.Organismo;

public record OrganismoDTO(
    Integer id,
    String nome,
    String descricao,
    String sigla
    ) {
        public OrganismoDTO(Organismo organismo){
            this(
                organismo.getId(),
                organismo.getNome(),
                organismo.getDescricao(),
                organismo.getDescricao()
            );
        }
}
