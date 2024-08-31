package com.unig4telco.grecio.diogo.Backend.Modules.security.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unig4telco.grecio.diogo.Backend.Modules.security.domain.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long>{
    List<Permission> findByRole_Id(Long id);
}
