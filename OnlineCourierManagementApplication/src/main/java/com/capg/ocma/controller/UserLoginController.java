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

/*
 * Author : YAMINI C and JEGANNATH P S
 * Version : 1.0
 * Date : 07-04-2021
 * Description : This is User Login Controller
*/

@RestController
@RequestMapping("api/ocma/login")
public class UserLoginController {

	static String userNotFoundException = "Username cannot contain Numbers or Special Characters!!";
	
	final Logger logger = LoggerFactory.getLogger(UserLoginController.class);
	
	@Autowired
	private IUserLoginService service;
	
	
	/********************************************************************************************************************************
	 * Method              : addUser 
	 * Description         : It is used to add new user into user_login table
	 * @param user         : UserLogin Object
	 * @PostMapping        : It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody        : It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * @exception          : UserNotFoundException
	 * Created By          : YAMINI C
     * Created Date        : 07-04-2021 
	 * 
	 *********************************************************************************************************************************/
	
	@PostMapping("/add-user")
	public void addUser(@RequestBody UserLogin user) throws UserNotFoundException {
		
		if(!UserLoginServiceImp.validateUsername(user.getUsername()))
			throw new UserNotFoundException(userNotFoundException);
		else
			service.addUser(user);
		
		logger.info("User logged-in successfully.");
	}

	/********************************************************************************************************************************
	 * Method              : userLogin 
	 * Description         : It is used to login an existing user into user_login table
	 * @param user         : UserLogin Object
	 * @PostMapping        : It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody        : It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * @exception          : UserNotFoundException
	 * Created By          : YAMINI C
     * Created Date        : 07-04-2021 
	 * 
	 *********************************************************************************************************************************/
	
	@PostMapping("/user-login")
	public void userLogin(@RequestBody UserLogin user) throws UserNotFoundException {
		
		if(!UserLoginServiceImp.validateUsername(user.getUsername()))
			throw new UserNotFoundException(userNotFoundException);
		else
			service.userLogin(user);
		
		logger.info("User logged-in successfully.");
	}
	
	/********************************************************************************************************************************
	 * Method              : removeUser 
	 * Description         : It is used to delete an existing user into user_login table
	 * @param userId       : long userId
	 * @DeleteMapping      : It is used to handle the HTTP DELETE requests matched with given URI expression.
	 * Created By          : JEGANNATH P S
     * Created Date        : 07-04-2021 
	 * 
	 *********************************************************************************************************************************/
	
	@DeleteMapping("/delete-user/{userId}")
	public void removeUser(@PathVariable long userId) throws UserNotFoundException 
	{
		service.removeUser(userId);
		
		logger.info("User deleted in successfully.");
	}

	/********************************************************************************************************************************
	 * Method              : userLogin 
	 * Description         : It is used to login an existing user into user_login table
	 * @param user         : UserLogin Object
	 * @RequestBody        : It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * @exception          : UserNotFoundException
	 * Created By          : JEGANNATH P S
     * Created Date        : 07-04-2021 
	 * 
	 *********************************************************************************************************************************/

	@PutMapping("/update-user")
	public void updateUser(@RequestBody UserLogin user) throws UserNotFoundException {
		
		if(!UserLoginServiceImp.validateUsername(user.getUsername()))
			throw new UserNotFoundException(userNotFoundException);
		else
			service.updateUser(user);
		
		logger.info("User updated successfully.");
	}

}
