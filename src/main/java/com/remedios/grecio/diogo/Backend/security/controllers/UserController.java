package com.remedios.grecio.diogo.Backend.security.controllers;

import com.remedios.grecio.diogo.Backend.security.DTO.LoginRequestDTO;
import com.remedios.grecio.diogo.Backend.security.DTO.TokenDetailJWT;
import com.remedios.grecio.diogo.Backend.security.domain.User;
import com.remedios.grecio.diogo.Backend.security.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

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
