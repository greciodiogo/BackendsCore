package com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.estadoCivil.estadoCivilRegistar;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.Helpers.EnvelopeResponse;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.estadoCivil._domain.EstadoCivil;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.estadoCivil._repositories.EstadoCivilRepository;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.estadoCivil.estadoCivilListar.DTO.EstadoCivilDTO;

@RestController
public class EstadoCivilRegistarController {
   @Autowired
    private EstadoCivilRepository estadoCivilRepository;

     @PostMapping("/estado_civils")
    public ResponseEntity<EnvelopeResponse<List<EstadoCivilDTO>>> saveestadoCivil(@RequestBody EstadoCivilDTO estadoCivilDTO) {
        // Criando o objeto estadoCivils a partir do DTO
        EstadoCivil estadoCivil = new EstadoCivil();
        estadoCivil.setNome(estadoCivilDTO.nome()); // Pode ser nulo
        estadoCivil.setSlug(estadoCivilDTO.slug());

        estadoCivil.setIs_actived(estadoCivilDTO.is_actived() != null ? estadoCivilDTO.is_actived() : true); // Valor padrão: true (ativo)
        estadoCivil.setIs_deleted(estadoCivilDTO.is_deleted() != null ? estadoCivilDTO.is_deleted() : false); // Valor padrão: true (ativo)
        estadoCivil.setCreatedAt(estadoCivilDTO.created_at() != null ? estadoCivilDTO.created_at() : new Date()); // Data atual
        estadoCivil.setUpdatedAt(estadoCivilDTO.updated_at() != null ? estadoCivilDTO.updated_at() : new Date()); // Data atual

   
        // Salvando no banco de dados
        EstadoCivil savedestadoCivil = estadoCivilRepository.save(estadoCivil);

        // Convertendo de volta para DTO usando record
        EstadoCivilDTO savedEstadoCivilDTO = new EstadoCivilDTO(
            savedestadoCivil.getId(),
            savedestadoCivil.getNome(),
            savedestadoCivil.getSlug(),
            savedestadoCivil.getIs_actived(),
            savedestadoCivil.getIs_deleted(),
            savedestadoCivil.getCreatedAt(),
            savedestadoCivil.getUpdatedAt()
        );

        EnvelopeResponse<List<EstadoCivilDTO>> response = new EnvelopeResponse<>(
            List.of(savedEstadoCivilDTO),   // Dado retornado
            "Estado Civil salvo com sucesso!", // Mensagem
            201                        // Código de status para criação
        );

        return ResponseEntity.status(201).body(response);
    }
}
