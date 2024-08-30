package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.clienteAniversarianteListar.DTO;

import org.springframework.web.bind.annotation.RequestParam;

public record RequestBirthDayListDTO(
    @RequestParam(defaultValue = "1") Integer page,
    @RequestParam(defaultValue = "5") Integer perPage,
    @RequestParam(defaultValue = "id") String orderBy,
    @RequestParam(defaultValue = "DESC") String typeOrderBy,
    @RequestParam(defaultValue = "") String typeFilter,
    @RequestParam(defaultValue = "") String search,
    @RequestParam(defaultValue = "") String mes,
    @RequestParam(defaultValue = "") String tipoClienteId,
    @RequestParam(defaultValue = "") String dataAniversario
){}
