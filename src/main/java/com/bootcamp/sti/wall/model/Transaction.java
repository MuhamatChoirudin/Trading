package com.bootcamp.sti.wall.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="Transaction")
@Table(name="tb_transaction")
public class Transaction {
	@Id
	@Column(name = "id_transaction")	
	private String idTransaction;
	
	@Column(name="account_number_debit")
	private String accountDebit;
	
	@Column(name="account_number_credit")
	private String accountCredit;

	@Column(name="date")
	private Date date;
	
	@Column(name="description")
	private String description;
	
	@Column(name="amount")
	private double amount;
	
	@ManyToOne
	@JoinColumn(name="id_transaction_type")
	private TransactionType transactionType;

	@ManyToOne
	@JoinColumn(name="id_bank")
	private Bank bank;

	public String getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(String idTransaction) {
		this.idTransaction = idTransaction;
	}

	
	
	public String getAccountDebit() {
		return accountDebit;
	}

	public void setAccountDebit(String accountDebit) {
		this.accountDebit = accountDebit;
	}

	public String getAccountCredit() {
		return accountCredit;
	}

	public void setAccountCredit(String accountCredit) {
		this.accountCredit = accountCredit;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}



	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	
}
