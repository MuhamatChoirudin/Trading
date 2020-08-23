package com.bootcamp.sti.wall.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="Outstanding")
@Table(name="tb_outstanding")
public class Outstanding {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_outstanding")	
	private int idOutstanding;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="outstanding")
	private double outstandingData;
	
	@ManyToOne
	@JoinColumn(name="id_trader")
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
