package com.vamos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vamos.domain.Usuario;

public interface EstudanteRepository extends JpaRepository<Usuario, Integer> {

}
