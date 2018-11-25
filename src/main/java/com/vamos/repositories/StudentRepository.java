package com.vamos.repositories;

import com.vamos.domain.VanGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.vamos.domain.Student;

import java.util.List;

public interface StudentRepository extends UserBaseRepository<Student>, JpaRepository<Student, Integer> {

	@Transactional(readOnly=true)
    Student findByEmail(String email);
}
