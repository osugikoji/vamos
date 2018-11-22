package com.vamos.repositories;

import com.vamos.domain.Student;
import com.vamos.domain.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

    @Transactional(readOnly=true)
    @Query("SELECT obj FROM Passenger obj WHERE obj.id.student = :student")
    List<Passenger> findAll(@Param("student") Student student);
}
