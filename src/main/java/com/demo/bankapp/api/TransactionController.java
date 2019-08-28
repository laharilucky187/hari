package com.demo.bankapp.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bankapp.dto.TransactionsDto;
import com.demo.bankapp.service.TransactionService;

@RestController
@RequestMapping("/api/v1/banking/transactions")
public class TransactionController {
	
	TransactionService transactionService;
	
	public TransactionController(final  TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	@GetMapping
	public ResponseEntity<List<TransactionsDto>> getTransactionsByAccountId(@RequestParam(value = "accountId", required = true)Long accountId ){
		
		List<TransactionsDto> transactionList = this.transactionService.getTransactionsByAccountId(accountId);
		
		return new ResponseEntity<List<TransactionsDto>>(transactionList, HttpStatus.OK);
	}

}
