package com.unig4telco.grecio.diogo.Backend.Modules.geografica.DTO;

import com.unig4telco.grecio.diogo.Backend.Modules.geografica.domain.Provincia;

public record ProvinciaDTO(
    Integer id, 
    String nome,
    String abreviacao
) {
    public ProvinciaDTO(Provincia provincia){
        this(
            provincia.getId(),
            provincia.getNome(),
            provincia.getAbreviatura()
        );
    }
}
