package com.unig4telco.grecio.diogo.Backend.Modules.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.unig4telco.grecio.diogo.Backend.Modules.security.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByUsername(String username);
}