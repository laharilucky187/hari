package com.demo.bankapp.exception;

public class AccountNotFoundException extends RuntimeException {
	
	public AccountNotFoundException(final String errorMessage) {
		super(errorMessage);
	}

}
