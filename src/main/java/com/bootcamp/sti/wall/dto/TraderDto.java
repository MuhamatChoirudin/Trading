package com.bootcamp.sti.wall.dto;

import com.bootcamp.sti.wall.model.Customer;
import com.bootcamp.sti.wall.model.StatusType;

public class TraderDto {

	private String idTrader;
	private String nameTrader;
	private double balance;
	private StatusType idStatusType;
	private Customer customer;
	public String getIdTrader() {
		return idTrader;
	}
	public void setIdTrader(String idTrader) {
		this.idTrader = idTrader;
	}
	public String getNameTrader() {
		return nameTrader;
	}
	public void setNameTrader(String nameTrader) {
		this.nameTrader = nameTrader;
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
