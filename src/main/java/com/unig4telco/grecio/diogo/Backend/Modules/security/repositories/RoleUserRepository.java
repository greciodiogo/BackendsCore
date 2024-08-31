package com.unig4telco.grecio.diogo.Backend.Modules.security.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unig4telco.grecio.diogo.Backend.Modules.security.domain.RoleUser;

public interface RoleUserRepository extends JpaRepository<RoleUser, Long>{
    List<RoleUser> findByUsers_Id(Integer id);
}
