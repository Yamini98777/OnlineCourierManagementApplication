package com.capg.ocma.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capg.ocma.exception.AccountNotFoundException;
import com.capg.ocma.exception.ComplaintNotFoundException;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.exception.CustomerNotFoundException;
import com.capg.ocma.exception.GlobalException;
import com.capg.ocma.exception.OutletClosedException;
import com.capg.ocma.exception.OutletNotFoundException;
import com.capg.ocma.exception.StaffMemberNotFoundException;
import com.capg.ocma.exception.UserNotFoundException;

@ControllerAdvice
public class GlobalController {

	@ExceptionHandler(ComplaintNotFoundException.class)
	public ResponseEntity<String> exceptionHandler(ComplaintNotFoundException exception)
	{
		String errorMessage = exception.getMessage();
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<String> exceptionHandler1(AccountNotFoundException exception)
	{
		String errorMessage = exception.getMessage();
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(CourierNotFoundException.class)
	public ResponseEntity<String> exceptionHandler2(CourierNotFoundException exception)
	{
		String errorMessage = exception.getMessage();
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> exceptionHandler3(CustomerNotFoundException exception)
	{
		String errorMessage = exception.getMessage();
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(OutletNotFoundException.class)
	public ResponseEntity<String> exceptionHandler4(OutletNotFoundException exception)
	{
		String errorMessage = exception.getMessage();
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(OutletClosedException.class)
	public ResponseEntity<String> exceptionHandler5(OutletClosedException exception)
	{
		String errorMessage = exception.getMessage();
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(StaffMemberNotFoundException.class)
	public ResponseEntity<String> exceptionHandler5(StaffMemberNotFoundException exception)
	{
		String errorMessage = exception.getMessage();
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> exceptionHandler6(UserNotFoundException exception)
	{
		String errorMessage = exception.getMessage();
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
}