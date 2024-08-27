package com.unig4telco.grecio.diogo.Backend.crm.DTO;


import com.unig4telco.grecio.diogo.Backend.crm.domain.TipoConta;

public record TipoContaDTO(

    Integer id,
    String nome,
    String slug,
    String tipoFacturacao,
    Boolean isVenda,
    Boolean isActived
    
){    public TipoContaDTO(TipoConta tipoconta) {
        this(
        tipoconta.getId(),
        tipoconta.getNome(),
        tipoconta.getSlug(),
        tipoconta.getTipoFacturacao(),
        tipoconta.getIsVenda(),
        tipoconta.getIsActived()
);    }
}
