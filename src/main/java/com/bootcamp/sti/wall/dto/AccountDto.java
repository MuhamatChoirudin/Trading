package com.bootcamp.sti.wall.dto;

import java.util.Date;

import com.bootcamp.sti.wall.model.Customer;
import com.bootcamp.sti.wall.model.StatusType;
public class AccountDto {
	private String accountNumber;
	private String cashtag;
	private Date openDate;
	private double balance;
	private StatusType idStatusType;
	private Customer customer;
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCashtag() {
		return cashtag;
	}
	public void setCashtag(String cashtag) {
		this.cashtag = cashtag;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public StatusType getIdStatusType() {
		return idStatusType;
	}
	public void setIdStatusType(StatusType idStatusType) {
		this.idStatusType = idStatusType;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	
	
	
}
