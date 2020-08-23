package com.bootcamp.sti.wall.dto;

import java.util.Date;

import com.bootcamp.sti.wall.model.Currency;
import com.bootcamp.sti.wall.model.Trader;

public class TransactionForexDto {
	private int idTransactionForex;
	private String buySell;
	private Date date;
	private double potensialPoinLose;
	private double pointLose;
	private double amount;
	private double rate;
	private double amountAfterSell;
	private Trader idTrader;
	private Currency currency;
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
	public double getPointLose() {
		return pointLose;
	}
	public void setPointLose(double pointLose) {
		this.pointLose = pointLose;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double getAmountAfterSell() {
		return amountAfterSell;
	}
	public void setAmountAfterSell(double amountAfterSell) {
		this.amountAfterSell = amountAfterSell;
	}
	public Trader getIdTrader() {
		return idTrader;
	}
	public void setIdTrader(Trader idTrader) {
		this.idTrader = idTrader;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	
	
	
	
}
