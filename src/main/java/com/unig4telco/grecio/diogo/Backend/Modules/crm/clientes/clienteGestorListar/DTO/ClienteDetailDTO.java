package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.clienteGestorListar.DTO;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._domain.Clientes;

public record ClienteDetailDTO(
        Integer id,
        String nome,
        String email,
        String morada,
        String contribuente,
        String telefone,
        String direccao

) {
        public ClienteDetailDTO(Clientes cliente) {
            this(
                    cliente.getId(),
                    cliente.getNome(),
                    cliente.getEmail(),
                    cliente.getMorada(),
                    cliente.getContribuente(),
                    cliente.getTelefone(),
                    cliente.getDireccao()
            );
        }

}
