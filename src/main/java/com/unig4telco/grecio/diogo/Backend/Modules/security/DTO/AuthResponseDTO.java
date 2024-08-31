package com.unig4telco.grecio.diogo.Backend.Modules.security.DTO;

import java.security.Permission;
import java.util.List;

import com.unig4telco.grecio.diogo.Backend.Modules.security.domain.Role;
import com.unig4telco.grecio.diogo.Backend.Modules.security.domain.User;

public record AuthResponseDTO<T>(
        Token<T> token,
        User user,
        Role role,
        List<Permission> permissions
    ) {  
        public AuthResponseDTO(String token, User user,Role role, List<Permission> permissions) {
            this(
                new Token<>("Bearer",token),
                user, 
                role,
                permissions
                );
        }
    
    public record Token<T>(
        String type,
        String token
        ) {}

}