package com.vamos.repositories;

import com.vamos.domain.StatusDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyScheduleRepository extends JpaRepository<StatusDay, Integer> {

}
