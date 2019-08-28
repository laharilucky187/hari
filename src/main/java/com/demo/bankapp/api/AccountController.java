package com.demo.bankapp.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bankapp.dto.AccountsDto;
import com.demo.bankapp.request.OpenAccountRequest;
import com.demo.bankapp.service.AccountsService;

@RestController
@RequestMapping("/api/v1/banking/accounts/")
public class AccountController {
	
	AccountsService accountsService;
	
	public AccountController(final AccountsService accountsService) {
		this.accountsService = accountsService;
	}

	@PostMapping(path = "account:open")
	public ResponseEntity<AccountsDto> openAccount(@RequestBody OpenAccountRequest openAccountDto){
		
		AccountsDto newAccount = this.accountsService.openAccount(openAccountDto);
		
		return new ResponseEntity<AccountsDto>(newAccount, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<AccountsDto>> getAccountsByCustomerId(@RequestParam(value = "customerId", required = true)Long customerId ){
		
		List<AccountsDto> accountList = this.accountsService.findByCustomerId(customerId);
		
		return new ResponseEntity<List<AccountsDto>>(accountList, HttpStatus.OK);
	}
}
