package com.demo.bankapp.dto;

import java.time.LocalDate;

public class TransactionsDto {
	
	private Long transactionId;
	private AccountsDto  accountDto;
	private double amount;
	private double balance;
	private LocalDate transactionDate;
	
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public AccountsDto getAccountDto() {
		return accountDto;
	}
	public void setAccountDto(AccountsDto accountDto) {
		this.accountDto = accountDto;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	
	
}
