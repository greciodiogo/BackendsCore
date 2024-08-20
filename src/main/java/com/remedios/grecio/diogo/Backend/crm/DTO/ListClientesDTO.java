package com.remedios.grecio.diogo.Backend.crm.DTO;

import com.remedios.grecio.diogo.Backend.crm.domain.Clientes;

public record ListClientesDTO(
        Integer id,
        String nome
//        String email,
//        String morada,
//        String contribuente,
//        String telefone
        ) {

        public ListClientesDTO(Clientes cliente){
                this(
                        cliente.getId(),
                        cliente.getNome());
//                        cliente.getEmail(),
//                        cliente.getMorada(),
//                        cliente.getContribuente(),
//                        cliente.getTelefone());
        }
}
