package com.vamos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vamos.domain.User;

public interface UserBaseRepository<T extends User> extends JpaRepository<T, Integer> {

}
