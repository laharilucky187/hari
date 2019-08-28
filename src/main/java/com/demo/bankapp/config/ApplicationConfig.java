package com.demo.bankapp.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.bankapp.entity.CustomerEntity;
import com.demo.bankapp.persistence.CustomerRepository;

@Configuration
public class ApplicationConfig {
	
	private Logger log = LoggerFactory.getLogger(getClass());

	@Bean
	InitializingBean initData(CustomerRepository customerRepository) {
		
		return () -> {
			
			customerRepository.save(new CustomerEntity("Alok", "Mishra"));
			customerRepository.save(new CustomerEntity("Sam", "Manuel"));
			customerRepository.save(new CustomerEntity("Bira", "Son"));
			customerRepository.save(new CustomerEntity("Haven", "Make"));
			customerRepository.save(new CustomerEntity("Noah", "Maan"));
			
			List<CustomerEntity> customerList = customerRepository.findAll();
			
			customerList.forEach(customerEntity -> log.info("customer_id: " + customerEntity.getCustomerId()));
		};
		
	}
	
}