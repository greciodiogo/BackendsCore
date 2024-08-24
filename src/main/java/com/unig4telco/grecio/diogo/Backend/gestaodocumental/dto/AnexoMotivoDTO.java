package com.unig4telco.grecio.diogo.Backend.gestaodocumental.dto;

import com.unig4telco.grecio.diogo.Backend.gestaodocumental.domain.AnexoMotivo;


public record AnexoMotivoDTO(
    Integer id,
    String nome,
    String descricao,
    String area
) {
    public AnexoMotivoDTO(AnexoMotivo anexoMotivo){
        this(
            anexoMotivo.getId(),
            anexoMotivo.getNome(),
            anexoMotivo.getDescricao(),
            anexoMotivo.getArea()
        );
    }
    
}
