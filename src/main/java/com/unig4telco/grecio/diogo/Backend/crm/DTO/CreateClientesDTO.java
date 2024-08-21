package com.unig4telco.grecio.diogo.Backend.crm.DTO;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record CreateClientesDTO (
        Integer id,
        @NotBlank
        String nome,
        @NotBlank
        String contribuente,
        String email,
        String morada,
        String direccao,
        Date created_at,
        Date updated_at
) {}

