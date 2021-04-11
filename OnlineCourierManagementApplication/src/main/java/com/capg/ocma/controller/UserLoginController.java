package com.capg.ocma.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ocma.entities.UserLogin;
import com.capg.ocma.exception.UserNotFoundException;
import com.capg.ocma.service.IUserLoginService;
import com.capg.ocma.service.UserLoginServiceImp;


@RestController
@RequestMapping("api/ocma/login")
public class UserLoginController {

	static String userNotFoundException = "Username cannot contain Numbers or Special Characters!!";
	
	final Logger logger = LoggerFactory.getLogger(UserLoginController.class);
	
	@Autowired
	IUserLoginService service;
	
	@PostMapping("/add-user")
	public void addUser(@RequestBody UserLogin user) throws UserNotFoundException {
		
		if(!UserLoginServiceImp.validateUsername(user.getUsername()))
			throw new UserNotFoundException(userNotFoundException);
		else
			service.addUser(user);
		
		logger.info("User logged-in successfully.");
	}

	
	@PostMapping("/user-login")
	public void userLogin(@RequestBody UserLogin user) throws UserNotFoundException {
		
		if(!UserLoginServiceImp.validateUsername(user.getUsername()))
			throw new UserNotFoundException(userNotFoundException);
		else
			service.userLogin(user);
		
		logger.info("User logged-in successfully.");
	}
	
	
	@DeleteMapping("/delete-user/{userId}")
	public void removeUser(@PathVariable long userId) throws UserNotFoundException 
	{
		service.removeUser(userId);
		
		logger.info("User deleted in successfully.");
	}


	@PutMapping("/update-user")
	public void updateUser(@RequestBody UserLogin user) throws UserNotFoundException {
		
		if(!UserLoginServiceImp.validateUsername(user.getUsername()))
			throw new UserNotFoundException(userNotFoundException);
		else
			service.updateUser(user);
		
		logger.info("User updated successfully.");
	}

}
