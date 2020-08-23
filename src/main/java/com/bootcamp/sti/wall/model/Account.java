package com.bootcamp.sti.wall.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity(name="Account")
@Table(name="tb_account")
public class Account {
	@Id
	@Column(name = "account_number")	
	private String accountNumber;
	
	@Column(name="cashtag")
	private String cashtag;
	
	@Column(name="open_date")
	private Date openDate;
	
	@Column(name="balance")
	private double balance;
	
	@ManyToOne
	@JoinColumn(name="id_status_type")
	private StatusType idStatusType;
	
	@ManyToOne
	@JoinColumn(name="cif")
	private Customer customer;

	

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

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
