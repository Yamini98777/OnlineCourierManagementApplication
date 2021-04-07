package com.capg.ocma.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.capg.ocma.entities.UserLogin;
import com.capg.ocma.exception.UserNotFoundException;
import com.capg.ocma.repository.UserLoginDao;

public class UserLoginServiceImp implements IUserLoginService {

	@Autowired
	private UserLoginDao repo;
	
	@Override
	public void addUser(UserLogin user) throws UserNotFoundException {
		
		
	}

	@Override
	public void removeUser(long userid) throws UserNotFoundException {
		
		
	}

	@Override
	public void updateUser(UserLogin user) throws UserNotFoundException {
		
		
	}
	
	
	
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
