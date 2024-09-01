package com.unig4telco.grecio.diogo.Backend.Modules.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.Helpers.EnvelopeResponse;
import com.unig4telco.grecio.diogo.Backend.Modules.security.DTO.AuthResponseDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.security.DTO.LoginRequestDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.security.domain.Permission;
import com.unig4telco.grecio.diogo.Backend.Modules.security.domain.PermissionField;
import com.unig4telco.grecio.diogo.Backend.Modules.security.domain.Role;
import com.unig4telco.grecio.diogo.Backend.Modules.security.domain.User;
import com.unig4telco.grecio.diogo.Backend.Modules.security.repositories.PermissionFieldRepository;
import com.unig4telco.grecio.diogo.Backend.Modules.security.repositories.PermissionRepository;
import com.unig4telco.grecio.diogo.Backend.Modules.security.repositories.RoleRepository;
import com.unig4telco.grecio.diogo.Backend.Modules.security.services.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private AuthenticationManager manager ;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PermissionFieldRepository permissionFieldRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private PermissionRepository permissionRepository;

    @PostMapping("/login")
    public ResponseEntity<EnvelopeResponse<?>> login(@RequestBody @Valid LoginRequestDTO jsonBody) {
        var token = new UsernamePasswordAuthenticationToken(jsonBody.username(), jsonBody.password());
        var authenticacao = manager.authenticate(token);

        var generateToken = tokenService.generateToken((User) authenticacao.getPrincipal());

        var user = (User) authenticacao.getPrincipal();
       
         // Buscar role do usuário
        List<PermissionField> permissionField = permissionFieldRepository.findAll();
        Role role = roleRepository.findByUserId(user.getId());

        // Supondo que `Permission` está relacionada a `Role`
        List<Permission> permissions = permissionRepository.findPermissionsByUserId(user.getId());


        var authResponse = new AuthResponseDTO(
            generateToken,  user, role, permissions, permissionField);
            
        EnvelopeResponse<?> data = new EnvelopeResponse<>(
            authResponse,
            "Usuário logado com sucesso",
            200
        );
        return ResponseEntity.ok(data);
    }
}
