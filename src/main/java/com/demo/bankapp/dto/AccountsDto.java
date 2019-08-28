package com.demo.bankapp.dto;

import com.demo.bankapp.enumeration.AccountType;

public class AccountsDto {
	
	private Long accountId;
	private AccountType accountType;
	
	
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

}
