package com.unig4telco.grecio.diogo.Backend.crm.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.unig4telco.grecio.diogo.Backend.crm.domain.DireccaoArea;
import com.unig4telco.grecio.diogo.Backend.crm.services.DireccaoAreaService;

@RestController
@RequestMapping("/direccao_areas")
public class DireccaoAreaController {

    private final DireccaoAreaService direccaoareaService;

    public DireccaoAreaController(DireccaoAreaService direccaoareaService) {
        this.direccaoareaService = direccaoareaService;
    }

    @GetMapping
    public ResponseEntity<List<DireccaoArea>> findAll() {
        List<DireccaoArea> lista = direccaoareaService.findAll();
        return ResponseEntity.ok(lista);
    }
}
