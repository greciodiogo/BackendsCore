package com.unig4telco.grecio.diogo.Backend.Helpers;

public record EnvelopeResponse<T>(
    T data,
    String message,
    Integer statusCode
) {
}
