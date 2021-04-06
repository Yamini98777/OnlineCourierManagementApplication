package com.capg.ocma.service;

import com.capg.ocma.entities.UserLogin;
import com.capg.ocma.exception.UserNotFoundException;

public interface IUserLoginService {

	public void addUser(UserLogin user) throws UserNotFoundException;
	public void removeUser(long userid) throws UserNotFoundException;
	public void updateUser(UserLogin user) throws UserNotFoundException;
	
}
