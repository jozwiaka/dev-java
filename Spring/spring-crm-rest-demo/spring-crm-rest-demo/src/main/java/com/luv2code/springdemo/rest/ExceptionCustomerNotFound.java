package com.luv2code.springdemo.rest;

public class ExceptionCustomerNotFound extends RuntimeException{

	public ExceptionCustomerNotFound() {
		super();
	}

	public ExceptionCustomerNotFound(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExceptionCustomerNotFound(String message, Throwable cause) {
		super(message, cause);
	}

	public ExceptionCustomerNotFound(String message) {
		super(message);
	}

	public ExceptionCustomerNotFound(Throwable cause) {
		super(cause);
	}

}
