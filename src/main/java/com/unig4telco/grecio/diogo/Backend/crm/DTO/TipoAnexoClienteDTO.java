package com.unig4telco.grecio.diogo.Backend.crm.DTO;

import com.unig4telco.grecio.diogo.Backend.crm.DTO.TipoAnexoClienteDTO;
import com.unig4telco.grecio.diogo.Backend.crm.domain.TipoAnexoCliente;
import com.unig4telco.grecio.diogo.Backend.gestaodocumental.dto.TipoAnexoDTO;

public record TipoAnexoClienteDTO(

    Integer id,
    String descricao,
    Boolean required,
    Boolean is_aprovacao,
    Boolean is_actived,
    Integer tipoAnexo_id,
    TipoAnexoDTO tipoAnexo,
    Integer tipoCliente_id,
    TipoClienteDTO tipoCliente

){    public TipoAnexoClienteDTO(TipoAnexoCliente tipoanexocliente) {
        this(
            tipoanexocliente.getId(),
            tipoanexocliente.getDescricao(),
            tipoanexocliente.getRequired(),
            tipoanexocliente.getIsAprovacao(),
            tipoanexocliente.getIsActived(),
            tipoanexocliente.getTipoAnexo() != null ? tipoanexocliente.getTipoAnexo().getId() : null,
            tipoanexocliente.getTipoAnexo() != null ? new TipoAnexoDTO(tipoanexocliente.getTipoAnexo()) : null,
            tipoanexocliente.getTipoCliente() != null ? tipoanexocliente.getTipoCliente().getId() : null,
            tipoanexocliente.getTipoAnexo() != null ? new TipoClienteDTO(tipoanexocliente.getTipoCliente()) : null
            );  }
}
