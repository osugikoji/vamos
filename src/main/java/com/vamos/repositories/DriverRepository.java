package com.vamos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.vamos.domain.Driver;

public interface DriverRepository extends UserBaseRepository<Driver>, JpaRepository<Driver, Integer> {
	
	@Transactional(readOnly=true)
    Driver findByEmail(String email);
}
