package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.clienteListar.DTO;

import org.springframework.web.bind.annotation.RequestParam;

public record RequestClientListDTO(
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "5") Integer perPage,
        @RequestParam(defaultValue = "id") String orderBy,
        @RequestParam(defaultValue = "DESC") String typeOrderBy,
        @RequestParam(defaultValue = "") String typeFilter,
        @RequestParam(defaultValue = "") String estado,
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
){}

