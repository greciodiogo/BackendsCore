package com.unig4telco.grecio.diogo.Backend.Modules.utilitarios.DTO;

import com.unig4telco.grecio.diogo.Backend.Modules.utilitarios.domain.Moeda;

public record MoedaDTO(
    Integer id,
    String nome,
    String codigoIso,
    String descricao,
    String unidade_fracionaria
){
    public MoedaDTO(Moeda moeda){
        this(
            moeda.getId(),
            moeda.getNome(),
            moeda.getCodigoIso(),
            moeda.getDescricao(),
            moeda.getUnidade_fracionaria()
        );
    }
}
