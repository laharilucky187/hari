package com.demo.bankapp.api;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.bankapp.dto.AccountsDto;
import com.demo.bankapp.entity.AccountsEntity;
import com.demo.bankapp.entity.CustomerEntity;
import com.demo.bankapp.entity.TransactionEntity;
import com.demo.bankapp.enumeration.AccountType;
import com.demo.bankapp.persistence.AccountsRepository;
import com.demo.bankapp.persistence.CustomerRepository;
import com.demo.bankapp.persistence.TransactionRepository;
import com.demo.bankapp.request.OpenAccountRequest;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerTest {
	
	private static final String ACCOUNT_API_PATH = "/api/v1/banking/accounts";
	
	@MockBean
	AccountsRepository accountsRepository;
	
	@MockBean
	CustomerRepository customerRepository;
	
	@MockBean
	TransactionRepository transactionRepository;
	
	@Autowired
    private TestRestTemplate restTemplate;
	
	@Test
	public void openAccountTest() {
		
		
		when(this.customerRepository.save(Mockito.any(CustomerEntity.class))).thenReturn(createCustomerEntity());
		
		when(this.accountsRepository.save(Mockito.any(AccountsEntity.class))).thenReturn(createAccEntity());
		
		when(this.transactionRepository.save(Mockito.any(TransactionEntity.class))).thenReturn(createTrxEntity());
		
		OpenAccountRequest openAccountRequest = new OpenAccountRequest();
		openAccountRequest.setAccountType(AccountType.CURRENT);
		openAccountRequest.setCustomerId(1l);
		openAccountRequest.setInitialCredit(19.00);
		
		HttpEntity<OpenAccountRequest> request = new HttpEntity<>(openAccountRequest);
		ResponseEntity<AccountsDto> entity = restTemplate.exchange(ACCOUNT_API_PATH+"/account:open", HttpMethod.POST, request, AccountsDto.class);
		
		assertThat(entity.getStatusCode(), equalTo(HttpStatus.CREATED));
		assertThat(entity.getBody().getAccountId(), equalTo(123l));
		
	}
	
	
	private CustomerEntity createCustomerEntity() {
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setCustomerId(1l);
		customerEntity.setFirstName("Alok");
		customerEntity.setLastName("Mishra");
		return customerEntity;
	}
	
	private AccountsEntity createAccEntity() {
		AccountsEntity accountsEntity = new AccountsEntity();
		accountsEntity.setAccountId(123l);
		accountsEntity.setAccountType(AccountType.CURRENT.name());
		accountsEntity.setCustomerEntity(createCustomerEntity());
		return accountsEntity;
	}
	
	private TransactionEntity createTrxEntity() {
		
		TransactionEntity transactionEntity = new TransactionEntity();
		transactionEntity.setAccountEntityFrom(createAccEntity());
		transactionEntity.setAmount(19);
		transactionEntity.setBalance(19);
		transactionEntity.setDate(LocalDate.now());
		return transactionEntity;
	}
}
