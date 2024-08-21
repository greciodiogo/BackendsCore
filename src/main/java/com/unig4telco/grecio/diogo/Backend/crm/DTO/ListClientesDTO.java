package com.unig4telco.grecio.diogo.Backend.crm.DTO;

import com.unig4telco.grecio.diogo.Backend.crm.domain.Clientes;
import com.unig4telco.grecio.diogo.Backend.crm.domain.TipoCliente;
import com.unig4telco.grecio.diogo.Backend.geografica.DTO.PaisDTO;
import com.unig4telco.grecio.diogo.Backend.geografica.DTO.ProvinciaDTO;
import com.unig4telco.grecio.diogo.Backend.geografica.domain.Pais;
import com.unig4telco.grecio.diogo.Backend.geografica.domain.Provincia;

public record ListClientesDTO(
                Integer id,
                String nome,
                Integer genero_id,
                GeneroDTO genero,
                Integer estado_civil_id,
                EstadoCivilDTO estado_civil,
                Integer identidade_id,
                IdentidadeDTO identidade,
                String email,
                String morada,
                String contribuente,
                String telefone,
                String aprovacao_documentacao,
                String origem,
                String estado,
                Integer pais_id,
                PaisDTO pais,
                Integer provincia_id,
                ProvinciaDTO provincia,
                Integer tipo_nacionalidade_id,
                TipoNacionalidadeDTO tipo_nacionalidade,
                Integer tipo_cliente_id,
                TipoClienteDTO tipo_cliente,
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
                        cliente.getIdentidade() != null ? cliente.getIdentidade().getId() : null,
                        cliente.getIdentidade() != null ? new IdentidadeDTO(cliente.getIdentidade()) : null,
                        cliente.getEmail(),
                        cliente.getMorada(),
                        cliente.getContribuente(),
                        cliente.getTelefone(),
                        cliente.getAprovacao_documentacao(),
                        cliente.getOrigem(),
                        cliente.getEstado(),
                        cliente.getPais() != null ? cliente.getPais().getId() : null,
                        cliente.getPais() != null ? new PaisDTO(cliente.getPais()) : null,
                        cliente.getProvincia() != null ? cliente.getProvincia().getId() : null,
                        cliente.getProvincia() != null ? new ProvinciaDTO(cliente.getProvincia()) : null,
                        cliente.getTipo_nacionalidade() != null ? cliente.getTipo_nacionalidade().getId() : null,
                        cliente.getTipo_nacionalidade() != null ? new TipoNacionalidadeDTO(cliente.getTipo_nacionalidade()) : null,
                        cliente.getTipo_cliente() != null ? cliente.getTipo_cliente().getId() : null,
                        cliente.getTipo_cliente() != null ? new TipoClienteDTO(cliente.getTipo_cliente()) : null,

                        cliente.getUser_id()                        
                        );       
        }
}
