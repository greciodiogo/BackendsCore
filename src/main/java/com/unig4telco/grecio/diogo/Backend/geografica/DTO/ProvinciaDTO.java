package com.unig4telco.grecio.diogo.Backend.geografica.DTO;

import com.unig4telco.grecio.diogo.Backend.geografica.domain.Provincia;

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
