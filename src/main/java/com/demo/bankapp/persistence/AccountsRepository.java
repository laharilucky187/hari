package com.demo.bankapp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.bankapp.entity.AccountsEntity;
import com.demo.bankapp.entity.CustomerEntity;

import java.util.List;

@Repository
public interface AccountsRepository extends JpaRepository<AccountsEntity, Long> {

	List<AccountsEntity> findByCustomerEntity(CustomerEntity customerentity);
}
