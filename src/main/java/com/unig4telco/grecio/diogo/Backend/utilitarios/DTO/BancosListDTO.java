package com.unig4telco.grecio.diogo.Backend.utilitarios.DTO;

import com.unig4telco.grecio.diogo.Backend.utilitarios.domain.Bancos;

public record BancosListDTO(
        Integer id,
        String nome,
        String abreviatura,
        String iban,
        Boolean activo,
        Boolean is_deleted,
        Integer user_id
) {
    public BancosListDTO(Bancos bancos) {
        this(
                bancos.getId(),
                bancos.getNome(),
                bancos.getAbreviatura(),
                bancos.getIban(),
                bancos.getActivo(),
                bancos.getIs_deleted(),
                bancos.getUser_id()
        );

    }

}
