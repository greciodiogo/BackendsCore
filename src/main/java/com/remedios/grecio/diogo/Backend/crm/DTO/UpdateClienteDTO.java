package com.remedios.grecio.diogo.Backend.crm.DTO;

import com.remedios.grecio.diogo.Backend.crm.domain.Clientes;
import jakarta.validation.constraints.NotNull;

public record UpdateClienteDTO(
        @NotNull
        Integer id,
        String nome,
        String contribuente,
        String direccao,
        String telefone,
        String email,
        String morada
        ) {

    public UpdateClienteDTO(Clientes cliente){
        this(
                cliente.getId(),
                cliente.getNome(),
                cliente.getContribuente(),
                cliente.getDireccao(),
                cliente.getTelefone(),
                cliente.getEmail(),
                cliente.getMorada());
    }
}
