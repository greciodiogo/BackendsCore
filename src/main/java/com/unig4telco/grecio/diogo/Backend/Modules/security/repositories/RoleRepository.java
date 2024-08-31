package com.unig4telco.grecio.diogo.Backend.Modules.security.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.unig4telco.grecio.diogo.Backend.Modules.security.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
    List<Role> findByUsers_Id(Integer id);
}
