package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.clienteContaDebitoListar.DTO;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._domain.ClienteContaDebito;

public record ClienteContaDebitoDTO(
    Integer id, 
    String num_conta,
    String iban,
    String descricao,
    Integer cliente_id,
    Integer banco_id,
    Boolean isActived
) {
    public ClienteContaDebitoDTO(ClienteContaDebito clienteContaDebito){
        this(
            clienteContaDebito.getId(),
            clienteContaDebito.getNum_conta(),
            clienteContaDebito.getIban(),
            clienteContaDebito.getDescricao(),
            clienteContaDebito.getCliente_id(),
            clienteContaDebito.getBanco_id(),
            clienteContaDebito.getIsActived()
        );
    }
}
