package com.vamos.repositories;

import com.vamos.domain.DailySchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyScheduleRepository extends JpaRepository<DailySchedule, Integer> {

    List<DailySchedule> findAllByStudent_Id(Integer id);
}
