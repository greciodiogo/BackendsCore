package com.unig4telco.grecio.diogo.Backend.Modules.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unig4telco.grecio.diogo.Backend.Modules.security.domain.RoleUser;

public interface RoleUserRepository extends JpaRepository<RoleUser, Long>{
}
