package com.vamos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vamos.domain.Usuario;

public interface MotoristaRepository extends JpaRepository<Usuario, Integer> {

}
