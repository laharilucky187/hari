package com.demo.bankapp.service;

import java.util.List;

import com.demo.bankapp.dto.AccountsDto;
import com.demo.bankapp.request.OpenAccountRequest;

public interface AccountsService {
	
	AccountsDto openAccount(OpenAccountRequest openAccountdto);
	
	List<AccountsDto> findByCustomerId(Long customerId);

}
