package com.vamos.repositories;

import com.vamos.domain.VanGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GroupRepository extends JpaRepository<VanGroup, Integer>{
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM VanGroup obj WHERE obj.driver.id = :driverId ORDER BY obj.name")
	List<VanGroup> findGroupsByDriverId(@Param("driverId") Integer driver_id);
}
