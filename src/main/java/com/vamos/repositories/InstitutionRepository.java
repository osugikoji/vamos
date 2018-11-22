package com.vamos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vamos.domain.Institution;

public interface InstitutionRepository extends JpaRepository<Institution, Integer> {

}
