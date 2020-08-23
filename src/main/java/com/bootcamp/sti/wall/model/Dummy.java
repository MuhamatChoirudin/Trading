package com.bootcamp.sti.wall.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Dummy")
@Table(name="tb_dummy")
public class Dummy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_dummy")	
	private int idDummy;
	
	@Column(name="name")
	private String name;
	

	
	@Column(name="balance")
	private double balance;


	public int getIdDummy() {
		return idDummy;
	}

	public void setIdDummy(int idDummy) {
		this.idDummy = idDummy;
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
