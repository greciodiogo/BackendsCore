package com.unig4telco.grecio.diogo.Backend.crm.controllers.DTO;

import java.util.List;

public record ApiResponseDTO<T>(
        Data<T> data,
        String message,
        int statusCode
        ) {

      public ApiResponseDTO(List<T> data, PaginationResponse pagination, String message, int statusCode) {
        this(
            new Data<>(
                data,
                pagination.page() + 1,
                pagination.perPage(),
                pagination.total(),
                pagination.lastPage()
            ),
            message,
            statusCode
        );
    }

    public record Data<T>(
        List<T> data,
        int page,
        int perPage,
        long total,
        int lastPage
    ) {}
}