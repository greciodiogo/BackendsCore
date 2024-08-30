package com.unig4telco.grecio.diogo.Backend.configs.direccao.direccaoAreaListar.DTO;

import com.unig4telco.grecio.diogo.Backend.configs.direccao._domain.DireccaoArea;
import com.unig4telco.grecio.diogo.Backend.configs.direccao.direccaoListar.DTO.DireccaoDTO;

public record DireccaoAreaDTO(

    Integer id,
    String nome,
    String slug,
    Integer direccao_id,
    DireccaoDTO direccao
    
){    public DireccaoAreaDTO(DireccaoArea direccaoarea) {
        this(
        direccaoarea.getId(),
        direccaoarea.getNome(),
        direccaoarea.getSlug(),
        direccaoarea.getDireccao() != null ? direccaoarea.getDireccao().getId() : null,
        direccaoarea.getDireccao() != null ? new DireccaoDTO(direccaoarea.getDireccao()) : null
);    }
}
