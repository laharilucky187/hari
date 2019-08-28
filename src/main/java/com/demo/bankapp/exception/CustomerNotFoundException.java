package com.demo.bankapp.exception;

public class CustomerNotFoundException extends RuntimeException {
	
	public CustomerNotFoundException(final String errorMessage) {
		super(errorMessage);
	}

}
