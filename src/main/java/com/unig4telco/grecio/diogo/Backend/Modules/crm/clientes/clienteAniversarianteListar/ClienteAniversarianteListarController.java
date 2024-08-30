package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.clienteAniversarianteListar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.unig4telco.grecio.diogo.Backend.Helpers.ApiResponseDTO;
import com.unig4telco.grecio.diogo.Backend.Helpers.PaginationResponse;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._services.ClienteService;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.clienteAniversarianteListar.DTO.BirthdayPersonList;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.clienteAniversarianteListar.DTO.RequestBirthDayListDTO;

@RestController
@RequestMapping("/clientes")
public class ClienteAniversarianteListarController {
   @Autowired
   private ClienteService clienteService;
    
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
