package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.tipoClienteListar.DTO;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._domain.TipoCliente;

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
