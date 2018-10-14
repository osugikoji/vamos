package com.vamos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.vamos.domain.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Integer>{
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Grupo obj WHERE obj.motorista.id = :motoristaId ORDER BY obj.nome")
	List<Grupo> findGruposByMotorista(@Param("motoristaId") Integer motorista_id);
	
}
