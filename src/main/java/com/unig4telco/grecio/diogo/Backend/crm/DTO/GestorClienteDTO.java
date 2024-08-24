package com.unig4telco.grecio.diogo.Backend.crm.DTO;

import com.unig4telco.grecio.diogo.Backend.crm.domain.GestorCliente;
import com.unig4telco.grecio.diogo.Backend.security.DTO.UserDTO;

public record GestorClienteDTO(
    Integer id,
    String funcao, 
    Boolean is_actived,
    Integer gestor_id,
    UserDTO gestor,
    Integer cliente_id,
    ClienteDetailDTO cliente,
    Integer user_id
) {
    public GestorClienteDTO(GestorCliente gestorCliente){
        this(
            gestorCliente.getId(),
            gestorCliente.getFuncao(),
            gestorCliente.getIs_actived(),
            gestorCliente.getGestor() != null ? gestorCliente.getGestor().getId() : null,
            gestorCliente.getGestor() != null ? new UserDTO(gestorCliente.getGestor()) : null,
            gestorCliente.getCliente() != null ? gestorCliente.getCliente().getId() : null,
            gestorCliente.getCliente() != null ? new ClienteDetailDTO(gestorCliente.getCliente()) : null,
            gestorCliente.getGestor() != null ? gestorCliente.getGestor().getId() : null
        );
    } 
}
