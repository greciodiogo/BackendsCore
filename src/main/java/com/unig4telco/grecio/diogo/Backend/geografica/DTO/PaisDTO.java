package com.unig4telco.grecio.diogo.Backend.geografica.DTO;

import com.unig4telco.grecio.diogo.Backend.geografica.domain.Pais;

public record PaisDTO(
    Integer id, 
    String nome
) {
    public PaisDTO(Pais pais){
        this(
            pais.getId(),
            pais.getNome()
        );
    }
}
