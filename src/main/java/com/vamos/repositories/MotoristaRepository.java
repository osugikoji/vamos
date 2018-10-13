package com.vamos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.vamos.domain.Motorista;

public interface MotoristaRepository extends UsuarioBaseRepository<Motorista>, JpaRepository<Motorista, Integer> {
	
	@Transactional(readOnly=true)
	Motorista findByEmail(String email);
}
