package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.entidadeCativadorasListar.DTO;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._domain.EntidadeCativadora;

public record EntidadeCativadoraDTO(
    Integer id, 
    String nome
) {
    public EntidadeCativadoraDTO(EntidadeCativadora entidadeCativadora){
        this(
            entidadeCativadora.getId(),
            entidadeCativadora.getNome()
        );
    }
}

