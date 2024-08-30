package com.unig4telco.grecio.diogo.Backend.Modules.security.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import com.unig4telco.grecio.diogo.Backend.Modules.security.DTO.LoginRequestDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.security.DTO.TokenDetailJWT;
import com.unig4telco.grecio.diogo.Backend.Modules.security.domain.User;
import com.unig4telco.grecio.diogo.Backend.Modules.security.services.TokenService;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private AuthenticationManager manager ;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequestDTO jsonBody) {
        var token = new UsernamePasswordAuthenticationToken(jsonBody.username(), jsonBody.password());
        var authenticacao = manager.authenticate(token);

        var generateToken = tokenService.generateToken((User) authenticacao.getPrincipal());

        return ResponseEntity.ok(new TokenDetailJWT(generateToken));
    }
}
