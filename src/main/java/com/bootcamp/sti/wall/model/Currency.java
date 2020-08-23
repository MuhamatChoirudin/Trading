package com.bootcamp.sti.wall.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Currency")
@Table(name="tb_currency")
public class Currency {
	@Id

	@Column(name = "id_currency")	
	private int idCurrency;
	
	@Column(name = "ccy_base")	
	private String ccyBase;
	
	@Column(name = "ccy_destination")	
	private String ccyDestination;
	
	@Column(name = "date")	
	private Date date;

	@Column(name = "buy")	
	private double buy;
	
	@Column(name = "sell")	
	private double sell;
	
	@Column(name = "description")
	private String description;
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIdCurrency() {
		return idCurrency;
	}

	public void setIdCurrency(int idCurrency) {
		this.idCurrency = idCurrency;
	}

	public String getCcyBase() {
		return ccyBase;
	}

	public void setCcyBase(String ccyBase) {
		this.ccyBase = ccyBase;
	}

	public String getCcyDestination() {
		return ccyDestination;
	}

	public void setCcyDestination(String ccyDestination) {
		this.ccyDestination = ccyDestination;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getBuy() {
		return buy;
	}

	public void setBuy(double buy) {
		this.buy = buy;
	}

	public double getSell() {
		return sell;
	}

	public void setSell(double sell) {
		this.sell = sell;
	}



	
	
	
}
