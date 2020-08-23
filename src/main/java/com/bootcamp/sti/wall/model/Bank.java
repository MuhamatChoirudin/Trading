package com.bootcamp.sti.wall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Bank")
@Table(name="tb_bank")
public class Bank {
	@Id
	@Column(name = "id_bank")	
	private String idBank;
	
	@Column(name="nama")
	private String name;
	
	@Column(name="balance")
	private double balance;

	public String getIdBank() {
		return idBank;
	}

	public void setIdBank(String idBank) {
		this.idBank = idBank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	

}
