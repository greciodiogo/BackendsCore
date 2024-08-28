package com.unig4telco.grecio.diogo.Backend.crm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.unig4telco.grecio.diogo.Backend.crm.DTO.*;
import com.unig4telco.grecio.diogo.Backend.crm.controllers.DTO.ApiResponseDTO;
import com.unig4telco.grecio.diogo.Backend.crm.controllers.DTO.PaginationResponse;
import com.unig4telco.grecio.diogo.Backend.crm.services.ClienteService;
@RestController
@RequestMapping("/clientes")
public class ClientesController {
   @Autowired
   private ClienteService clienteService;
    
    @GetMapping
    public ResponseEntity<ApiResponseDTO<ListClientesDTO>> index( RequestClientListDTO filters) {
    
        var pageResponse = clienteService.findAll(filters);

        ApiResponseDTO<ListClientesDTO> data = new ApiResponseDTO<>(
            pageResponse.getContent(),                            // Dados paginados
            PaginationResponse.fromPage(pageResponse),            // MetaData
            null,                                         // Mensagem (ou passe uma string)
            200                                        // Código de status
            );
        return ResponseEntity.ok(data);
    }

    @GetMapping("/birthday")
    public ResponseEntity<ApiResponseDTO<BirthdayPersonList>> findBirthdayPerson(
        RequestBirthDayListDTO filters) {
        var pageResponse = clienteService.findBirthdayPerson(filters);
    
        ApiResponseDTO<BirthdayPersonList> data = new ApiResponseDTO<>(
            pageResponse.getContent(),                            // Dados paginados
            PaginationResponse.fromPage(pageResponse),            // MetaData
            null,                                         // Mensagem (ou passe uma string)
            200                                        // Código de status
            );
    
        return ResponseEntity.ok(data);
    }

}
