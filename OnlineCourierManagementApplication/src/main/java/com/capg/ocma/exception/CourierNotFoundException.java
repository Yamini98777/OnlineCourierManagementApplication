package com.capg.ocma.exception;

public class CourierNotFoundException extends Exception {

private static final long serialVersionUID = 1L;
	
	public CourierNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
