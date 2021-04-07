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

@RestController
@RequestMapping("api/ocma/login")
public class UserLoginController {

	
	final Logger LOGGER = LoggerFactory.getLogger(UserLoginController.class);
	
	@Autowired
	IUserLoginService service;
	
	@PostMapping("/add-user")
	public void addUser(@RequestBody UserLogin user) throws UserNotFoundException {
		
		
		
		
		LOGGER.info("User logged in successfully.");
	}

	@DeleteMapping("/delete-user")
	public void removeUser(@PathVariable long userid) throws UserNotFoundException {
		
		
		
		
		LOGGER.info("User deleted in successfully.");
	}

	@PutMapping("/update-user")
	public void updateUser(@RequestBody UserLogin user) throws UserNotFoundException {
		
		
		
		LOGGER.info("User updated in successfully.");
	}

}
