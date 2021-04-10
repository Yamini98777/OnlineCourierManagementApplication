package com.capg.ocma.exception;

public class AccountNotFoundException extends GlobalException{
	private static final long serialVersionUID = 1L;

	public AccountNotFoundException(String message) {
		
		super(message);
	}

}
