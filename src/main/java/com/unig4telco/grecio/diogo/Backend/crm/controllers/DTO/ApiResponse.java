package com.unig4telco.grecio.diogo.Backend.crm.controllers.DTO;

import java.util.List;

public record ApiResponse<T>(
    List<T> data,
    int page,
    int perPage,
    long total,
    int lastPage) {      
    
    public ApiResponse(List<T> data, PaginationResponse pagination){
        this(
            data,
            pagination.page(),
            pagination.perPage(),
            pagination.total(),
            pagination.lastPage()
        );
    }
}
