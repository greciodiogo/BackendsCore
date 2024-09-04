package com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.generos.generosRegistar;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.Helpers.EnvelopeResponse;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.generos._domain.Generos;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.generos._repositories.GeneroRepository;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.generos.generosListar.DTO.GeneroDTO;

@RestController
public class GeneroRegistarController {
        @Autowired
    private GeneroRepository generoRepository;
    
     @PostMapping("/generos")
    public ResponseEntity<EnvelopeResponse<List<GeneroDTO>>> saveGenero(@RequestBody GeneroDTO generoDTO) {
        // Criando o objeto Generos a partir do DTO
        Generos genero = new Generos();
        genero.setDescricao(generoDTO.descricao()); // Pode ser nulo
        genero.setAbreviacao(generoDTO.abreviacao());
        genero.setSlug(generoDTO.slug());

        genero.setIs_actived(generoDTO.is_actived() != null ? generoDTO.is_actived() : true); // Valor padrão: true (ativo)
        genero.setIs_deleted(generoDTO.is_deleted() != null ? generoDTO.is_deleted() : true); // Valor padrão: true (ativo)
        genero.setCreatedAt(generoDTO.created_at() != null ? generoDTO.created_at() : new Date()); // Data atual
        genero.setUpdatedAt(generoDTO.updated_at() != null ? generoDTO.updated_at() : new Date()); // Data atual

   
        // Salvando no banco de dados
        Generos savedGenero = generoRepository.save(genero);

        // Convertendo de volta para DTO usando record
        GeneroDTO savedGeneroDTO = new GeneroDTO(
            savedGenero.getId(),
            savedGenero.getDescricao(),
            savedGenero.getAbreviacao(),
            savedGenero.getSlug(),
            savedGenero.getIs_actived(),
            savedGenero.getIs_deleted(),
            savedGenero.getCreatedAt(),
            savedGenero.getUpdatedAt()
        );

        EnvelopeResponse<List<GeneroDTO>> response = new EnvelopeResponse<>(
            List.of(savedGeneroDTO),   // Dado retornado
            "Gênero salvo com sucesso!", // Mensagem
            201                        // Código de status para criação
        );

        return ResponseEntity.status(201).body(response);
    }
}
