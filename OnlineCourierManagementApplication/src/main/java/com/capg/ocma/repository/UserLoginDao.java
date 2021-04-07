package com.capg.ocma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.ocma.entities.UserLogin;

@Repository
public interface UserLoginDao extends JpaRepository<UserLogin, Long> {
	

}
