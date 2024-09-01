package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.entidadeCativadorasListar.DTO;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._domain.EntidadeCativadora;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.clienteListar.DTO.ListClientesDTO;

public record EntidadeCativadoraDTO(
    Integer id, 
    String nome,
    Integer cliente_id,
    ListClientesDTO cliente
) {
    public EntidadeCativadoraDTO(EntidadeCativadora entidadeCativadora){
        this(
            entidadeCativadora.getId(),
            entidadeCativadora.getNome(),
            entidadeCativadora.getCliente() != null ? entidadeCativadora.getCliente().getId() : null,
            entidadeCativadora.getCliente() != null ? new ListClientesDTO(entidadeCativadora.getCliente()) : null
        );
    }
}

