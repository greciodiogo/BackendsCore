package com.unig4telco.grecio.diogo.Backend.utilitarios.DTO;

import com.unig4telco.grecio.diogo.Backend.utilitarios.domain.Cambio;

public record CambioDTO(
    Double valor_cambio,    
    Integer moeda_id,
    MoedaDTO moeda
) {
    public CambioDTO(Cambio cambio){
        this(
            cambio.getValor_cambio(),
            cambio.getMoeda() != null ? cambio.getMoeda().getId() : null,
            cambio.getMoeda() != null ? new MoedaDTO(cambio.getMoeda()) : null
        );
    }
    
}
