package com.remedios.grecio.diogo.Backend.crm.DTO;

import com.remedios.grecio.diogo.Backend.crm.domain.Clientes;

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
