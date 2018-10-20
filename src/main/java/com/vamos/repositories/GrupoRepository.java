package com.vamos.repositories;

import com.vamos.domain.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GrupoRepository extends JpaRepository<Grupo, Integer>{
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Grupo obj WHERE obj.motorista.id = :motoristaId ORDER BY obj.nome")
	List<Grupo> findGruposByMotoristaId(@Param("motoristaId") Integer motorista_id);
}
