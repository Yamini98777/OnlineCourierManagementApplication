package com.capg.ocma.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserLogin {

	@Id
	private String username;
	private String password;
	private String confirmPassword;

	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserLogin(String username, String password, String confirmPassword) {
		super();
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "UserLogin [username=" + username + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ "]";
	}

}
