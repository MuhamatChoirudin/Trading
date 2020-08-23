package com.bootcamp.sti.wall.dto;

import java.util.Date;

import com.bootcamp.sti.wall.model.Bank;
import com.bootcamp.sti.wall.model.TransactionType;


public class TransactionDto {

	private String idTransaction;
	private String accountDebit;
	private String accountCredit;
	private Date date;
	private String description;
	private double amount;
	private TransactionType transactionType;
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
