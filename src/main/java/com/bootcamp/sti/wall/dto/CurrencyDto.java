package com.bootcamp.sti.wall.dto;

import java.util.Date;


public class CurrencyDto {
	private int idCurrency;
	private String ccyBase;
	private String ccyDestination;
	private Date date;
	private double buy;
	private double sell;
	private String description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
