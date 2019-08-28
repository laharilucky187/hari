package com.demo.bankapp.request;

import javax.validation.constraints.NotNull;

import com.demo.bankapp.enumeration.AccountType;

public class OpenAccountRequest {
	
	@NotNull(message = "customerId cannot be missing or empty")
	private Long customerId;
	
	@NotNull(message = "accountType cannot be missing or empty")
	private AccountType accountType;
	
	private Double initialCredit;
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public Double getInitialCredit() {
		return initialCredit;
	}
	public void setInitialCredit(Double initialCredit) {
		this.initialCredit = initialCredit;
	}
	
	

}
