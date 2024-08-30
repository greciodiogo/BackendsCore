package com.unig4telco.grecio.diogo.Backend.Modules.security.DTO;

import com.unig4telco.grecio.diogo.Backend.Modules.security.domain.User;

public record UserDTO(
    Integer id,
    String name,
    String email,
    Boolean is_actived
    ) {
        public UserDTO(User user){
            this(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getIs_actived()
            );
    }
}
