package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.tipoClienteListar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._repositories.TipoClienteRepository;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.tipoClienteListar.DTO.TipoClienteDTO;

@RestController
@RequestMapping("/tipo_clientes")
public class TipoClienteListarController {
    @Autowired
    private TipoClienteRepository tipoClienteRepository;

        @GetMapping
    public ResponseEntity<List<TipoClienteDTO>> getTipoClientes() {
        var lista = tipoClienteRepository.findAll().stream().map(TipoClienteDTO::new).toList();
        return ResponseEntity.ok(lista);
    }

}