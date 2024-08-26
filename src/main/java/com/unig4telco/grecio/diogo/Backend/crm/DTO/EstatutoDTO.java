package com.unig4telco.grecio.diogo.Backend.crm.DTO;

import com.unig4telco.grecio.diogo.Backend.crm.domain.Estatuto;

public record EstatutoDTO(
        Integer id,
        String numeroMecanografico
) {
    public EstatutoDTO(Estatuto estatuto) {
        this(
                estatuto.getId(),
                estatuto.getNumeroMecanografico());
    }
}
