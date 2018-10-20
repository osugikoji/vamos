package com.vamos.repositories;

import com.vamos.domain.Estudante;
import com.vamos.domain.IntegranteGrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IntegranteGrupoRepository extends JpaRepository<IntegranteGrupo, Integer> {

    @Transactional(readOnly=true)
    @Query("SELECT obj FROM IntegranteGrupo obj WHERE obj.id.estudante = :estudante")
    List<IntegranteGrupo> findAll(@Param("estudante") Estudante estudante);
}
