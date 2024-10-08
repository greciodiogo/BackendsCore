package com.unig4telco.grecio.diogo.Backend.Modules.configs.direccao._repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.unig4telco.grecio.diogo.Backend.Modules.configs.direccao._domain.DireccaoArea;

public interface DireccaoAreaRepository extends JpaRepository<DireccaoArea, Long>, JpaSpecificationExecutor<DireccaoArea>{}
