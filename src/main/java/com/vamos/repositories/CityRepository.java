package com.vamos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vamos.domain.City;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer>{

    List<City> findAllByState_Description(String state);
}
