package com.unig4telco.grecio.diogo.Backend.Helpers;

import org.springframework.data.domain.Page;

public record PaginationResponse(Integer page,
                                 Integer perPage,
                                 Long total,
                                 Integer lastPage) {

    public static PaginationResponse fromPage(Page<?> page) {
        return new PaginationResponse(
            page.getNumber(),
            page.getSize(),
            page.getTotalElements(),
            page.getTotalPages()
        );
    }
}
