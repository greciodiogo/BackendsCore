package com.unig4telco.grecio.diogo.Backend.crm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.crm.DTO.TipoAnexoClienteDTO;
import com.unig4telco.grecio.diogo.Backend.crm.DTO.TipoClienteDTO;
import com.unig4telco.grecio.diogo.Backend.crm.controllers.DTO.ApiResponseDTO;
import com.unig4telco.grecio.diogo.Backend.crm.controllers.DTO.PaginationResponse;
import com.unig4telco.grecio.diogo.Backend.crm.repositories.TipoClienteRepository;
import com.unig4telco.grecio.diogo.Backend.crm.services.TipoAnexoClienteService;


@RestController
@RequestMapping("/tipo_clientes")
public class TipoClienteController {
    @Autowired
    private TipoClienteRepository tipoClienteRepository;

    @Autowired
    private TipoAnexoClienteService tipoAnexoClienteService;

        @GetMapping
    public ResponseEntity<List<TipoClienteDTO>> getTipoClientes() {
        var lista = tipoClienteRepository.findAll().stream().map(TipoClienteDTO::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/tipoAnexoClientes")
    public ResponseEntity<ApiResponseDTO<TipoAnexoClienteDTO>> index() {
    
        var pageResponse = tipoAnexoClienteService.findAll();

        ApiResponseDTO<TipoAnexoClienteDTO> data = new ApiResponseDTO<>(
            pageResponse.getContent(),                            // Dados paginados
            PaginationResponse.fromPage(pageResponse),            // MetaData
            null,                                         // Mensagem (ou passe uma string)
            200                                        // Código de status
            );
        return ResponseEntity.ok(data);
    }
}