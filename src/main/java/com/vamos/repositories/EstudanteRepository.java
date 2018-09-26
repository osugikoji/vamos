package com.vamos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vamos.domain.Estudante;

public interface EstudanteRepository extends UsuarioBaseRepository<Estudante>, JpaRepository<Estudante, Integer> {
	
}
