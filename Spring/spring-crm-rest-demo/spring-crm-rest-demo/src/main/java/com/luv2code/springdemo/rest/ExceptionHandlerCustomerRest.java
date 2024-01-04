package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerCustomerRest {

	@ExceptionHandler
	public ResponseEntity<ErrorResponseCustomer> handleException(ExceptionCustomerNotFound e)
	{
		ErrorResponseCustomer error = new ErrorResponseCustomer(
												HttpStatus.NOT_FOUND.value(),
												e.getMessage(),
												System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponseCustomer> handleException(Exception e)
	{
		ErrorResponseCustomer error = new ErrorResponseCustomer(
												HttpStatus.BAD_REQUEST.value(),
												e.getMessage(),
												System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
}
