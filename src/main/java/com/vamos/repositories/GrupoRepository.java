package com.vamos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vamos.domain.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Integer>{
	
}
