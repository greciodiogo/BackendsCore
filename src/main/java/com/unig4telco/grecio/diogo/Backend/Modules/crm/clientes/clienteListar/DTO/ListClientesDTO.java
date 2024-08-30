package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.clienteListar.DTO;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._domain.Clientes;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.tipoClienteListar.DTO.TipoClienteDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.estadoCivil.estadoCivilListar.DTO.EstadoCivilDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.generos.generosListar.DTO.GeneroDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.identidade.identidadeListar.DTO.IdentidadeDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.nacionalidade.tipoNacionalidadeListar.DTO.TipoNacionalidadeDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.geografica.DTO.PaisDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.geografica.DTO.ProvinciaDTO;

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
                Integer direccao_id,
                String direccao,
                String codigo_chamada,
                Integer distrito_id,
                String facebook,
                String numero_whatsapp,
                String observacao,
                String origem,
                String estado,
                Integer pais_id,
                PaisDTO pais,
                Integer provincia_id,
                ProvinciaDTO provincia,
                Integer tipo_nacionalidade_id,
                TipoNacionalidadeDTO tipoNacionalidade,
                Integer tipo_cliente_id,
                TipoClienteDTO tipoCliente,
                Integer user_id, 
                LocalDate DataNascimento,
                Date created_at,
                Date updated_at,
                @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
                Date dataRegisto,
                @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
                Date dataActualizacao
                ) {

        public ListClientesDTO (Clientes cliente){
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
                        cliente.getDireccao_id(),
                        cliente.getDireccao(),
                        cliente.getCodigo_chamada(),
                        cliente.getDistrito_id(),
                        cliente.getFacebook(),
                        cliente.getNumero_whatsapp(),
                        cliente.getObservacao(),
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
                        cliente.getUser_id(),                        
                        cliente.getDataNascimento(),                        
                        cliente.getCreatedAt(),                        
                        cliente.getUpdatedAt(),                        
                        cliente.getCreatedAt(),                        
                        cliente.getUpdatedAt()                        
                        );       
        }
}
