package com.demo.bankapp.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TRANSACTION")
public class TransactionEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Long transactionId;

    @JoinColumn(name = "accountId")
    @ManyToOne(fetch = FetchType.LAZY)
    private AccountsEntity accountEntityFrom;
    

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private double balance;
    
	@Column(nullable = false)
    private LocalDate date;


	public AccountsEntity getAccountEntityFrom() {
		return accountEntityFrom;
	}

	public void setAccountEntityFrom(AccountsEntity accountEntityFrom) {
		this.accountEntityFrom = accountEntityFrom;
	}

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAmount() {
		return amount;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
