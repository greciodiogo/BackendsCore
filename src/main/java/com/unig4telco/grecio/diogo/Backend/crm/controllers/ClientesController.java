package com.unig4telco.grecio.diogo.Backend.crm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.unig4telco.grecio.diogo.Backend.crm.DTO.*;
import com.unig4telco.grecio.diogo.Backend.crm.controllers.DTO.ApiResponse;
import com.unig4telco.grecio.diogo.Backend.crm.controllers.DTO.PaginationResponse;
import com.unig4telco.grecio.diogo.Backend.crm.helpers.PaginationService;
import com.unig4telco.grecio.diogo.Backend.crm.services.ClienteService;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
    @Autowired
    private PaginationService paginationService;
   @Autowired
   private ClienteService clienteService;
//
//    @PostMapping
//    @Transactional
//    public ResponseEntity<ClienteDetailDTO> saveRemedios(@RequestBody @Valid CreateClientesDTO jsonBody, UriComponentsBuilder uriBuilder) {
//        var cliente = new Clientes(jsonBody);
//        repository.save(cliente);
//
//        var uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
//        return ResponseEntity.created(uri).body(new ClienteDetailDTO(cliente));
//    }

    // @GetMapping
    // public ResponseEntity<List<ListClientesDTO>> getClientesWithPagination() {
    //     var lista = paginationService.getClientesWithPagination(1,6).stream().map(ListClientesDTO::new).toList();
    //     return ResponseEntity.ok(lista);
    // }

    
    @GetMapping
    public ResponseEntity<ApiResponse<ListClientesDTO>> index(
        @RequestParam(defaultValue = "1") int pageNo,
        @RequestParam(defaultValue = "5") int pageSize) {
    
        var pageResponse = clienteService.findAll(pageNo, pageSize);
    
        // Criação da resposta com paginação
        var apiResponse = new ApiResponse<>(
            pageResponse.getContent(),                        // Dados paginados
            PaginationResponse.fromPage(pageResponse)         // Detalhes de paginação
        );
    
        return ResponseEntity.ok(apiResponse);
    }

//    @PutMapping
//    @Transactional
//    public ResponseEntity<ClienteDetailDTO> updateRemedio(@RequestBody @Valid UpdateClienteDTO jsonBody){
//        var remedio = repository.getReferenceById(Long.valueOf(jsonBody.id()));
//        remedio.updateCliente(jsonBody);
//
//        return ResponseEntity.ok(new ClienteDetailDTO(remedio));
//    }
//
//    @DeleteMapping("{id}")
//    @Transactional
//    public ResponseEntity<Void> excluir(@PathVariable Long id){
//        repository.deleteById(id);
//
//        return ResponseEntity.noContent().build();
//    }

//    @DeleteMapping("inactivar/{id}")
//    @Transactional
//    public ResponseEntity<Void> inactivar(@PathVariable Long id){
//        var remedio = repository.getReferenceById(id);
//        remedio.inactivarCliente();
//
//        return ResponseEntity.noContent().build();
//    }
//
//    @PutMapping("activar/{id}")
//    @Transactional
//    public ResponseEntity<Void> activar(@PathVariable Long id){
//        var remedio = repository.getReferenceById(id);
//        remedio.activarCliente();
//
//        return ResponseEntity.noContent().build();
//    }

//    @GetMapping("/{id}")
//    @Transactional
//    public ResponseEntity<ClienteDetailDTO> show(@PathVariable Long id){
//        var cliente = repository.getReferenceById(id);
//
//        return ResponseEntity.ok(new ClienteDetailDTO(cliente));
//    }
}
