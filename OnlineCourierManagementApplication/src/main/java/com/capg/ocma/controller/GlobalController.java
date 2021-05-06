package com.capg.ocma.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capg.ocma.exception.GlobalException;


@CrossOrigin(origins = "http://localhost:3000")
@ControllerAdvice
public class GlobalController {

	@ExceptionHandler(GlobalException.class)
	public ResponseEntity<String> exceptionHandler(Exception exception)
	{
		String errorMessage = exception.getMessage();
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
}
