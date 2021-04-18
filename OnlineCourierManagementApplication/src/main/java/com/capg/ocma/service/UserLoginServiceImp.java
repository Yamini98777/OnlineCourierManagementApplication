package com.capg.ocma.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ocma.entities.UserLogin;
import com.capg.ocma.exception.UserNotFoundException;
import com.capg.ocma.repository.UserLoginDao;

/*
 * Author      : YAMINI C and JEGANNATH P S
 * Version     : 1.0
 * Date        : 07-04-2021
 * Description : This is User Login Service Layer that provides operations such as add, login, update and delete user.
*/

@Service
public class UserLoginServiceImp implements IUserLoginService {

	final Logger logger = LoggerFactory.getLogger(UserLoginServiceImp.class);
	
	@Autowired
	private UserLoginDao repo;
	
	static String userNotFound = "User Not Found With Entered ID";
	
	@Override
	public void addUser(UserLogin user) {
			
		String encryptedPassword;
		encryptedPassword = encryptPassword(user.getPassword());
		user.setPassword(encryptedPassword);
		repo.save(user);
		
	}

	
	public void userLogin(UserLogin user) throws UserNotFoundException {
		
		UserLogin existUser = repo.findById(user.getUserId()).orElse(null);
		
		String encryptedPassword;
		String decryptedPassword;
		
		if(existUser == null) {
			throw new UserNotFoundException("User with the entered user ID does not exist");
		}
		else {
			encryptedPassword = existUser.getPassword();			
			decryptedPassword = decryptPassword(encryptedPassword);
			
			if(user.getPassword().equals(decryptedPassword)) 
				logger.info("Valid User");
			else 
				throw new UserNotFoundException("Wrong password!");
		}
		
	}
	
	
	@Override
	public void removeUser(long userId) throws UserNotFoundException {
		
		UserLogin user = repo.findById(userId).orElse(null);
		if(user == null) {
			throw new UserNotFoundException("User not found");
		}
		else 
			repo.delete(user);
		
	}

	
	public void updateUser(UserLogin user) throws UserNotFoundException {
		UserLogin user1 = repo.findById(user.getUserId()).orElse(null);
		
		if(user1 == null) {
			throw new UserNotFoundException("User not Found");
		}
		else
		{
			String encryptedPassword;
			encryptedPassword = encryptPassword(user.getPassword());
			user.setPassword(encryptedPassword);
			repo.save(user);
		}
	}
	
	
	
	
	public static boolean validateUsername(String username) throws UserNotFoundException
	{
		boolean flag = false;
		if(username == null)
			throw new UserNotFoundException("Username cannot be empty");
		else if(!username.matches("^[a-zA-Z]+$"))
			throw new UserNotFoundException("Username cannot contain Numbers or Special Characters");
		else
			flag = true;
		return flag;
	}
	
//	Caesar Cipher Encryption technique
	
	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	
	public String encryptPassword(String password)
	{
		int shiftKey=3;
		password = password.toLowerCase();
        String encryptedPassword = "";
        for (int i = 0; i < password.length(); i++)
        {
            int charPosition = ALPHABET.indexOf(password.charAt(i));
            int keyVal = (shiftKey + charPosition) % 26;
            char replaceVal = ALPHABET.charAt(keyVal);
            encryptedPassword += replaceVal;
        }
        return encryptedPassword;
	}
	
	public String decryptPassword(String encryptedPassword)
	{
		int shiftKey=3;
		encryptedPassword = encryptedPassword.toLowerCase();
        String password = "";
        for (int i = 0; i < encryptedPassword.length(); i++)
        {
            int charPosition = ALPHABET.indexOf(encryptedPassword.charAt(i));
            int keyVal = (charPosition - shiftKey) % 26;
            if (keyVal < 0)
            {
                keyVal = ALPHABET.length() + keyVal;
            }
            char replaceVal = ALPHABET.charAt(keyVal);
            password += replaceVal;
        }
        return password;
	}

	

}
