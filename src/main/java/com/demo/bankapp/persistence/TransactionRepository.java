package com.demo.bankapp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.bankapp.entity.AccountsEntity;
import com.demo.bankapp.entity.TransactionEntity;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

	List<TransactionEntity> findByAccountEntityFrom(AccountsEntity accountentityfrom);
}
