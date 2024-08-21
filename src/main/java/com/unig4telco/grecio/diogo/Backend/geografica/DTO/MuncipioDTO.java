package com.unig4telco.grecio.diogo.Backend.geografica.DTO;

import com.unig4telco.grecio.diogo.Backend.geografica.domain.Municipio;

public record MuncipioDTO(
    Integer id, 
    String nome
) {
    public MuncipioDTO(Municipio municipio){
        this(
            municipio.getId(),
            municipio.getNome()
        );
    }
}
