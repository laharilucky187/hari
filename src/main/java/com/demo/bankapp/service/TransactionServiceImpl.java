package com.demo.bankapp.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bankapp.dto.TransactionsDto;
import com.demo.bankapp.entity.AccountsEntity;
import com.demo.bankapp.entity.TransactionEntity;
import com.demo.bankapp.persistence.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	private TransactionRepository transactionRepository;
	
	@Autowired
	public TransactionServiceImpl(TransactionRepository transactionRepository) {
		
		this.transactionRepository = transactionRepository;
		
	}
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public void createTransaction(TransactionsDto transactionsDto) {
		
		transactionRepository.save(createTransactionEntity(transactionsDto));

	}
	
	private TransactionEntity createTransactionEntity(final TransactionsDto transactionsDto) {
		
		TransactionEntity transactionEntity = new TransactionEntity();
		
		AccountsEntity accountEntityFrom = new AccountsEntity();
		accountEntityFrom.setAccountId(transactionsDto.getAccountDto().getAccountId());
		transactionEntity.setAccountEntityFrom(accountEntityFrom);
		
		transactionEntity.setBalance(transactionEntity.getBalance() + transactionsDto.getAmount());
		transactionEntity.setDate(transactionsDto.getTransactionDate());
		transactionEntity.setAmount(transactionsDto.getAmount());
		
		return transactionEntity;
		
	}

	@Override
	public List<TransactionsDto> getTransactionsByAccountId(Long accountId) {
		
		AccountsEntity accountEntity = new AccountsEntity();
		accountEntity.setAccountId(accountId);
		
		List<TransactionEntity> transactionsEntityList = this.transactionRepository.findByAccountEntityFrom(accountEntity);
		
		ModelMapper mapper = new ModelMapper();
		List<TransactionsDto> transactionsDtoList = transactionsEntityList.stream()
													.map(entity -> mapper.map(entity, TransactionsDto.class))
													.collect(Collectors.toList());
		
		return transactionsDtoList;
		
	}

}
