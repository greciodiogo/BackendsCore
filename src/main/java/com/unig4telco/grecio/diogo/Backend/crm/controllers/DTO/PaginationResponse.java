package com.unig4telco.grecio.diogo.Backend.crm.controllers.DTO;

import org.springframework.data.domain.Page;

public record PaginationResponse(Integer page,
                                 Integer perPage,
                                 Long total,
                                 Integer totalPages) {

    public static PaginationResponse fromPage(Page<?> page) {
        return new PaginationResponse(
            page.getNumber(),
            page.getSize(),
            page.getTotalElements(),
            page.getTotalPages()
        );
    }
}
