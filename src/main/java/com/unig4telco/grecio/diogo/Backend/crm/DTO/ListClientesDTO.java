package com.unig4telco.grecio.diogo.Backend.crm.DTO;

import com.unig4telco.grecio.diogo.Backend.crm.domain.Clientes;

public record ListClientesDTO(
                Integer id,
                String nome,
                Integer genero_id,
                GeneroDTO genero,
                Integer estado_civil_id,
                EstadoCivilDTO estado_civil,
                Integer identidade_id,
                String email,
                String morada,
                String contribuente,
                String telefone,
                String aprovacao_documentacao,
                String origem,
                String estado,
                Integer pais_id,
                Integer provincia_id,
                Integer tipo_nacionalidade_id,
                Integer tipo_cliente_id,
                Integer user_id 
                ) {

        public ListClientesDTO(Clientes cliente){
                this(
                        cliente.getId(),
                        cliente.getNome(),
                        cliente.getGenero() != null ? cliente.getGenero().getId() : null,
                        cliente.getGenero() != null ? new GeneroDTO(cliente.getGenero()) : null,
                        cliente.getEstado_civil() != null ? cliente.getEstado_civil().getId() : null,
                        cliente.getEstado_civil() != null ? new EstadoCivilDTO(cliente.getEstado_civil()) : null,
                        cliente.getIdentidade_id(),
                        cliente.getEmail(),
                        cliente.getMorada(),
                        cliente.getContribuente(),
                        cliente.getTelefone(),
                        cliente.getAprovacao_documentacao(),
                        cliente.getOrigem(),
                        cliente.getEstado(),
                        cliente.getPais_id(),
                        cliente.getProvincia_id(),
                        cliente.getTipo_nacionalidade_id(),
                        cliente.getTipo_cliente_id(),
                        cliente.getUser_id()                        
                        );       
        }
}
