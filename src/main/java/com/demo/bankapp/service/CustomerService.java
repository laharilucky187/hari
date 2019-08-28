package com.demo.bankapp.service;

import java.util.List;

import com.demo.bankapp.dto.CustomerDto;

public interface CustomerService {
	
	CustomerDto getCustomer(Long customerId);
	
	List<CustomerDto> getCustomers();

}
