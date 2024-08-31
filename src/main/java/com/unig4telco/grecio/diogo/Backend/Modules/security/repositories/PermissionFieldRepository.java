package com.unig4telco.grecio.diogo.Backend.Modules.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unig4telco.grecio.diogo.Backend.Modules.security.domain.PermissionField;

public interface PermissionFieldRepository extends JpaRepository<PermissionField, Long> {
}
