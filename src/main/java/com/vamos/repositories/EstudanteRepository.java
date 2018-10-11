package com.vamos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.vamos.domain.Estudante;

public interface EstudanteRepository extends UsuarioBaseRepository<Estudante>, JpaRepository<Estudante, Integer> {

	@Transactional(readOnly=true)
	Estudante findByEmail(String email);
}
