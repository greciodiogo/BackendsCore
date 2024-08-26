package com.unig4telco.grecio.diogo.Backend.crm.DTO;

import com.unig4telco.grecio.diogo.Backend.crm.domain.Proposta;

public record PropostaDTO(

        Integer id,
        String descricao,
        String tipo,
        String estado

) {
    public PropostaDTO(Proposta proposta) {
        this(
                proposta.getId(),
                proposta.getDescricao(),
                proposta.getTipo(),
                proposta.getEstado()
                );
    }
}
