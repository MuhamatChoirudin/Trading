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

@Entity(name="TransactionForex")
@Table(name="tb_transaction_forex")
public class TransactionForex {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_forex")	
	private int idTransactionForex;
	
	@Column(name="buy_sell")
	private String buySell;

	@Column(name="transaction_date")
	private Date date;
	
	@Column(name="potensial_poin_lose")
	private double potensialPoinLose;
	
	@Column(name="point_lose")
	private double pointLose;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="rate")
	private double rate;
	
	@Column(name="amount_after_sell")
	private double amountAfterSell;
	
	@ManyToOne
	@JoinColumn(name="id_trader")
	private Trader idTrader;
	
	@ManyToOne
	@JoinColumn(name="id_currency")
	private Currency currency;
	

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Trader getIdTrader() {
		return idTrader;
	}

	public void setIdTrader(Trader idTrader) {
		this.idTrader = idTrader;
	}

	public int getIdTransactionForex() {
		return idTransactionForex;
	}

	public void setIdTransactionForex(int idTransactionForex) {
		this.idTransactionForex = idTransactionForex;
	}

	public String getBuySell() {
		return buySell;
	}

	public void setBuySell(String buySell) {
		this.buySell = buySell;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getPotensialPoinLose() {
		return potensialPoinLose;
	}

	public void setPotensialPoinLose(double potensialPoinLose) {
		this.potensialPoinLose = potensialPoinLose;
	}

	public double getAmountAfterSell() {
		return amountAfterSell;
	}

	public void setAmountAfterSell(double amountAfterSell) {
		this.amountAfterSell = amountAfterSell;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public double getPointLose() {
		return pointLose;
	}

	public void setPointLose(double pointLose) {
		this.pointLose = pointLose;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}	
}
