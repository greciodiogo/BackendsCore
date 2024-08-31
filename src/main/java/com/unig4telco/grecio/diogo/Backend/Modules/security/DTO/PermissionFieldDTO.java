package com.unig4telco.grecio.diogo.Backend.Modules.security.DTO;


public record PermissionFieldDTO(
    Integer id,
    String slug,
    Boolean is_deleted
    ) {}
