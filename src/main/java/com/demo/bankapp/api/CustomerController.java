package com.demo.bankapp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bankapp.dto.CustomerDto;
import com.demo.bankapp.service.CustomerService;

@RestController
@RequestMapping("/api/v1/banking/customers")
public class CustomerController {
	
	CustomerService customerService;
	
	@Autowired
	public CustomerController(final CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping(path = "/customer/{id}")
	public ResponseEntity<CustomerDto> customerDetails(@PathVariable("id") Long customerId){
		
		CustomerDto customer = this.customerService.getCustomer(customerId);
		
		return new ResponseEntity<CustomerDto>(customer, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<CustomerDto>> getCustomers(){
		
		List<CustomerDto> customerList = this.customerService.getCustomers();
		
		return new ResponseEntity<List<CustomerDto>>(customerList, HttpStatus.OK);
	}

}
