package com.bootcamp.sti.wall.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bootcamp.sti.wall.model.Trader;

public class OutstandingDto {

	private int idOutstanding;
	private Date date;
	private double outstandingData;
	private Trader idTrader;
	
	public int getIdOutstanding() {
		return idOutstanding;
	}

	public void setIdOutstanding(int idOutstanding) {
		this.idOutstanding = idOutstanding;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getOutstandingData() {
		return outstandingData;
	}

	public void setOutstandingData(double outstandingData) {
		this.outstandingData = outstandingData;
	}

	public Trader getIdTrader() {
		return idTrader;
	}

	public void setIdTrader(Trader idTrader) {
		this.idTrader = idTrader;
	}
}
