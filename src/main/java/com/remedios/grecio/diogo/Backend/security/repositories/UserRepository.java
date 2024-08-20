package com.remedios.grecio.diogo.Backend.security.repositories;

import com.remedios.grecio.diogo.Backend.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByUsername(String username);
}