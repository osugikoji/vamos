package com.vamos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vamos.models.Motorista;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

}
