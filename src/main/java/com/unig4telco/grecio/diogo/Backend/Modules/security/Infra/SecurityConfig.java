package com.unig4telco.grecio.diogo.Backend.Modules.security.Infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public DefaultSecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()); // Desativando CSRF. Certifique-se de que é necessário.
                // .sessionManagement(session -> session
                //         .sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Sem sessão (útil para APIs RESTful)
                // .authorizeHttpRequests(auth -> auth
                //         .requestMatchers(HttpMethod.POST, "/auth/login").permitAll() // Permitir POST em /login
                //         .requestMatchers(HttpMethod.GET, "/api/**").authenticated()); // Permitir qualquer outra rota após a autenticação
                //         // .anyRequest().authenticated()) // Qualquer outra requisição deve ser autenticada
                // // .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class); // Adicionando filtro customizado

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
