package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._domain;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.proposta._domain.Proposta;

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
