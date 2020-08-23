package com.bootcamp.sti.wall.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="Trader")
@Table(name="tb_trader")
public class Trader {
	@Id
	@Column(name = "id_trader")	
	private String idTrader;
	
	@Column(name="name_trader")
	private String nameTrader;
	
	
	@Column(name="balance")
	private double balance;
	
	@ManyToOne
	@JoinColumn(name="id_status_type")
	private StatusType idStatusType;
	
	@ManyToOne
	@JoinColumn(name="cif")
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public StatusType getIdStatusType() {
		return idStatusType;
	}

	public void setIdStatusType(StatusType idStatusType) {
		this.idStatusType = idStatusType;
	}

	
}
