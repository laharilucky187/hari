package com.demo.bankapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bankapp.dto.CustomerDto;
import com.demo.bankapp.entity.CustomerEntity;
import com.demo.bankapp.exception.CustomerNotFoundException;
import com.demo.bankapp.persistence.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	CustomerRepository customerRepository;

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Override
	public CustomerDto getCustomer(Long customerId) {
		
		Optional<CustomerEntity> customerEntity = customerRepository.findById(customerId);
		
		if(customerEntity.isPresent()) {
			ModelMapper mapper = new ModelMapper();
			return mapper.map(customerEntity.get(), CustomerDto.class);
		}else {
			throw new CustomerNotFoundException("No customer found for customerId: "+customerId);
		}
		
	}

	@Override
	public List<CustomerDto> getCustomers() {

		ModelMapper mapper = new ModelMapper();
		
		List<CustomerEntity> customerEntities = this.customerRepository.findAll();
		
		return customerEntities.stream().map(customerEntity -> mapper.map(customerEntity, CustomerDto.class)).collect(Collectors.toList());
	}

}
