package com.bootcamp.sti.wall.dto;

import java.util.Date;

import com.bootcamp.sti.wall.model.Account;
import com.bootcamp.sti.wall.model.Customer;
import com.bootcamp.sti.wall.model.WalletType;


public class WalletAccountDto {

	private String idWallet;
	private Date openDate;
	private WalletType walletType;
	private Account account;
	private Customer customer;
	public String getIdWallet() {
		return idWallet;
	}
	public void setIdWallet(String idWallet) {
		this.idWallet = idWallet;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public WalletType getWalletType() {
		return walletType;
	}
	public void setWalletType(WalletType walletType) {
		this.walletType = walletType;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	
}
