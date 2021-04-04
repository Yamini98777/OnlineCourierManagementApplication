package com.capg.ocma.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserLogin {
	
	@Id
	private String username;
	private String password;
	private String confirmPassword;
	
}
