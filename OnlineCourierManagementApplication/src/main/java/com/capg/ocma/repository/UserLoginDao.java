package com.capg.ocma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.ocma.entities.UserLogin;

/*
 * Author      : JEGENNATH P S and YAMINI C
 * Version     : 1.0
 * Date        : 03-04-2021
 * Description : This is User Login Repository
*/


@Repository
public interface UserLoginDao extends JpaRepository<UserLogin, Long>  {
	

}
