package com.demo.bankapp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bankapp.dto.AccountsDto;
import com.demo.bankapp.dto.TransactionsDto;
import com.demo.bankapp.entity.AccountsEntity;
import com.demo.bankapp.entity.CustomerEntity;
import com.demo.bankapp.persistence.AccountsRepository;
import com.demo.bankapp.request.OpenAccountRequest;

@Service
public class AccountsServiceImpl implements AccountsService {

	private AccountsRepository accountsRepository;
	private TransactionService transactionService;
	
	@Autowired
	public AccountsServiceImpl(final AccountsRepository accountsRepository, final TransactionService transactionService) {
		this.accountsRepository = accountsRepository;
		this.transactionService = transactionService;
	}
	
	@Override
	@Transactional
	public AccountsDto openAccount(OpenAccountRequest openAccountRequest) {

			ModelMapper mapper = new ModelMapper();
		
			AccountsEntity accountsEntity = this.createAccountsEntity(openAccountRequest);
			
			AccountsEntity savedEntity = this.accountsRepository.save(accountsEntity);
			
			AccountsDto accountsDto = mapper.map(savedEntity, AccountsDto.class);
			
			if(openAccountRequest.getInitialCredit() > 0 ) {
				this.createTransaction(openAccountRequest, accountsDto);
			}
			
			return accountsDto;
		
	}
	
	@Override
	public List<AccountsDto> findByCustomerId(Long customerId) {
		CustomerEntity customer = new CustomerEntity();
		customer.setCustomerId(customerId);
		
		List<AccountsEntity> accountList = accountsRepository.findByCustomerEntity(customer);
		
		ModelMapper mapper = new ModelMapper();
		
		List<AccountsDto> dtos = accountList.stream().map(entity -> mapper.map(entity, AccountsDto.class)).collect(Collectors.toList());
		return dtos;
	}
	
	private AccountsEntity createAccountsEntity(final OpenAccountRequest openAccountDto) {
		
		AccountsEntity accountsEntity = new AccountsEntity();
		accountsEntity.setAccountType(openAccountDto.getAccountType().name());
		
		CustomerEntity customer = new CustomerEntity();
		customer.setCustomerId(openAccountDto.getCustomerId());
		
		accountsEntity.setCustomerEntity(customer);
		
		return accountsEntity;
		
	}
	
	private void createTransaction(OpenAccountRequest openAccountRequest, AccountsDto accountsDto) {
		TransactionsDto transDto = new TransactionsDto();
		transDto.setAccountDto(accountsDto);
		transDto.setAmount(openAccountRequest.getInitialCredit());
		transDto.setBalance(transDto.getBalance() + openAccountRequest.getInitialCredit());
		transDto.setTransactionDate(LocalDate.now());
		
		this.transactionService.createTransaction(transDto);
	}

}
