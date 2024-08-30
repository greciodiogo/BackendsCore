package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.clienteEstatutoListar.DTO;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._domain.Estatuto;

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
