package com.unig4telco.grecio.diogo.Backend.crm.DTO;

import com.unig4telco.grecio.diogo.Backend.crm.domain.TipoCliente;

public record TipoClienteDTO(
    Integer id, 
    String nome,
    String slug
) {
    public TipoClienteDTO(TipoCliente tipoCliente){
        this(
            tipoCliente.getId(),
            tipoCliente.getNome(),
            tipoCliente.getSlug()
        );
    }
}
