package com.capg.ocma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.ocma.entities.UserLogin;

public interface UserLoginDao extends JpaRepository<UserLogin, Long> {

}
