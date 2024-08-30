package com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.estadoCivil.estadoCivilListar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.estadoCivil._repositories.EstadoCivilRepository;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.estadoCivil.estadoCivilListar.DTO.EstadoCivilDTO;


@RestController
@RequestMapping("/estado_civils")
public class EstadoCivilListarController {
    @Autowired
    private EstadoCivilRepository estadoCivilRepository;

        @GetMapping
    public ResponseEntity<List<EstadoCivilDTO>> getEstadoCivil() {
        var lista = estadoCivilRepository.findAll().stream().map(EstadoCivilDTO::new).toList();
        return ResponseEntity.ok(lista);
    }
}