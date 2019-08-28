package com.demo.bankapp.exception;

public class TransactionsNotFoundException extends RuntimeException {
	
	public TransactionsNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
