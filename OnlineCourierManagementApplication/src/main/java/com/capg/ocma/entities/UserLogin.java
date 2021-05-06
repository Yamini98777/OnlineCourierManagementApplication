package com.capg.ocma.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

 

@Entity
public class UserLogin {

	@Id
	private long userId;
	private String password;

	public UserLogin() {
		super();
	}

	public UserLogin(long userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserLogin [userId=" + userId + ", password=" + password + "]";
	}

}
