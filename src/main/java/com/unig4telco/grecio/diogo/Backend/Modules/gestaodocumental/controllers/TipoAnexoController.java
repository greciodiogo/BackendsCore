package com.unig4telco.grecio.diogo.Backend.Modules.gestaodocumental.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.Modules.gestaodocumental.anexo._services.TipoAnexoService;
import com.unig4telco.grecio.diogo.Backend.Modules.gestaodocumental.repositories.dto.TipoAnexoDTO;

@RestController
@RequestMapping("/tipoanexo")
public class TipoAnexoController {
    @Autowired
    private TipoAnexoService tipoAnexoService;

    @GetMapping
    public ResponseEntity<List<TipoAnexoDTO>> getTipoAnexos() {
        var lista = tipoAnexoService.findAll().stream().map(TipoAnexoDTO::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/getTypeAnexoBancario")
    public ResponseEntity<List<TipoAnexoDTO>> getTypeAnexoBancario() {
        List<TipoAnexoDTO> tipoAnexos = tipoAnexoService.typeAnexoBancario()
                .stream()
                .map(TipoAnexoDTO::new)
                .toList();

        return ResponseEntity.ok(tipoAnexos);
    }

    @GetMapping("/getTipoAnexoByPedido")
    public ResponseEntity<List<TipoAnexoDTO>> getTipoAnexoByPedido() {
        List<TipoAnexoDTO> tipoAnexos = tipoAnexoService.findByArea("Pedido")
                .stream()
                .map(TipoAnexoDTO::new)
                .toList();

        return ResponseEntity.ok(tipoAnexos);
    }
}
