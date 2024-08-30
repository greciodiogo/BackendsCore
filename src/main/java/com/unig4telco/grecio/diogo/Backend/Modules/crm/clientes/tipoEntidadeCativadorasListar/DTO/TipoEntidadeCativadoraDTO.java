package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.tipoEntidadeCativadorasListar.DTO;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._domain.TipoEntidadeCativadora;

public record TipoEntidadeCativadoraDTO(
    Integer id, 
    String nome
) {
    public TipoEntidadeCativadoraDTO(TipoEntidadeCativadora tipoEntidadeCativadora){
        this(
            tipoEntidadeCativadora.getId(),
            tipoEntidadeCativadora.getNome()
        );
    }
}

