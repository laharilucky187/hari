package com.demo.bankapp.service;

import java.util.List;

import com.demo.bankapp.dto.TransactionsDto;

public interface TransactionService {
	
	void createTransaction(TransactionsDto transactionsDto);
	
	List<TransactionsDto> getTransactionsByAccountId(Long accountId);

}
