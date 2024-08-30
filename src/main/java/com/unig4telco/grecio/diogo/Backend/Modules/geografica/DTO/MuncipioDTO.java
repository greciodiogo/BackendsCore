package com.unig4telco.grecio.diogo.Backend.Modules.geografica.DTO;

import com.unig4telco.grecio.diogo.Backend.Modules.geografica.domain.Municipio;

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
