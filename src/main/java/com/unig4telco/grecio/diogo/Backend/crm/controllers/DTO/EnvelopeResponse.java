package com.unig4telco.grecio.diogo.Backend.crm.controllers.DTO;

public record EnvelopeResponse<T>(
    T data,
    String message,
    Integer statusCode
) {
}
