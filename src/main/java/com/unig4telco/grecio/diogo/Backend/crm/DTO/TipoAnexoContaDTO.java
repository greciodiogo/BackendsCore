package com.unig4telco.grecio.diogo.Backend.crm.DTO;

import com.unig4telco.grecio.diogo.Backend.crm.domain.TipoAnexoConta;
import com.unig4telco.grecio.diogo.Backend.gestaodocumental.dto.TipoAnexoDTO;


public record TipoAnexoContaDTO(
    Integer id,
    String descricao,
    Boolean required,
    Boolean is_aprovacao,
    Boolean is_actived,
    Integer tipoAnexo_id,
    TipoAnexoDTO tipoAnexo,
    Integer tipoConta_id,
    TipoContaDTO tipoCliente

){    public TipoAnexoContaDTO(TipoAnexoConta tipoAnexoConta) {
    this(
        tipoAnexoConta.getId(),
        tipoAnexoConta.getDescricao(),
        tipoAnexoConta.getRequired(),
        tipoAnexoConta.getIsAprovacao(),
        tipoAnexoConta.getIsActived(),
        tipoAnexoConta.getTipoAnexo() != null ? tipoAnexoConta.getTipoAnexo().getId() : null,
        tipoAnexoConta.getTipoAnexo() != null ? new TipoAnexoDTO(tipoAnexoConta.getTipoAnexo()) : null,
        tipoAnexoConta.getTipoConta() != null ? tipoAnexoConta.getTipoConta().getId() : null,
        tipoAnexoConta.getTipoConta() != null ? new TipoContaDTO(tipoAnexoConta.getTipoConta()) : null
        );  }

}
