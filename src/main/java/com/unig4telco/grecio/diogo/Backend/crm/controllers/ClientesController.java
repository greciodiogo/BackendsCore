package com.unig4telco.grecio.diogo.Backend.crm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.unig4telco.grecio.diogo.Backend.crm.DTO.*;
import com.unig4telco.grecio.diogo.Backend.crm.controllers.DTO.ApiResponse;
import com.unig4telco.grecio.diogo.Backend.crm.controllers.DTO.EnvelopeResponse;
import com.unig4telco.grecio.diogo.Backend.crm.controllers.DTO.PaginationResponse;
import com.unig4telco.grecio.diogo.Backend.crm.services.ClienteService;
@RestController
@RequestMapping("/clientes")
public class ClientesController {
   @Autowired
   private ClienteService clienteService;
    
    @GetMapping
    public ResponseEntity<EnvelopeResponse<ApiResponse<ListClientesDTO>>> index(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "5") int perPage,
        @RequestParam(defaultValue = "id") String orderBy,
        @RequestParam(defaultValue = "DESC") String typeOrderBy,
        @RequestParam(defaultValue = "") String typeFilter,
        @RequestParam(defaultValue = "") String search,
        @RequestParam(defaultValue = "") String document,
        @RequestParam(defaultValue = "") String status,
        @RequestParam(defaultValue = "") String estadoRegisto,
        @RequestParam(defaultValue = "") String typeClientId,
        @RequestParam(defaultValue = "") String tipoConta,
        @RequestParam(defaultValue = "") String typeRegistoCliente,
        @RequestParam(defaultValue = "") String paisId,
        @RequestParam(defaultValue = "") String provinciaId,
        @RequestParam(defaultValue = "") String municipioId
        ) {
    
        var pageResponse = clienteService.findAll(page, perPage, typeClientId, document, estadoRegisto, search);
    
        // Criação da resposta com paginação
        var apiResponse = new ApiResponse<>(
            pageResponse.getContent(),                        // Dados paginados
            PaginationResponse.fromPage(pageResponse)         // Detalhes de paginação
        );

        var envelopeResponse = new EnvelopeResponse<>(
            apiResponse,          // Dados dentro da chave "data"
            "",                // Mensagem
            200                  // Result, caso precise adicionar algo no futuro
        );
    
        return ResponseEntity.ok(envelopeResponse);
    }

    @GetMapping("/birthday")
    public ResponseEntity<EnvelopeResponse<ApiResponse<BirthdayPersonList>>> findBirthdayPerson(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "5") int perPage,
        @RequestParam(defaultValue = "id") String orderBy,
        @RequestParam(defaultValue = "DESC") String typeOrderBy,
        @RequestParam(defaultValue = "") String typeFilter,
        @RequestParam(defaultValue = "") String search,
        @RequestParam(defaultValue = "") String mes,
        @RequestParam(defaultValue = "") String tipoClienteId,
        @RequestParam(defaultValue = "") String dataAniversario
        ) {
        var pageResponse = clienteService.findBirthdayPerson(page, perPage, tipoClienteId, mes, dataAniversario, search);
    
        var apiResponse = new ApiResponse<>(
            pageResponse.getContent(),                        // Dados paginados
            PaginationResponse.fromPage(pageResponse)         // Detalhes de paginação
        );

        var envelopeResponse = new EnvelopeResponse<>(
            apiResponse,          // Dados dentro da chave "data"
            "",                // Mensagem
            200                  // Result, caso precise adicionar algo no futuro
        );
    
        return ResponseEntity.ok(envelopeResponse);
    }

}
