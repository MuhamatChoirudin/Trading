package com.bootcamp.sti.wall.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="WalletAccount")
@Table(name="tb_wallet")
public class WalletAccount {
	@Id
	@Column(name = "id_wallet")	
	private String idWallet;

	@Column(name="open_date")
	private Date openDate;
	
	@ManyToOne
	@JoinColumn(name="id_wallet_type")
	private WalletType walletType;
	
	@ManyToOne
	@JoinColumn(name="account_number")
	private Account account;
	
	@ManyToOne
	@JoinColumn(name="cif")
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
		this.customer =customer;
		
	}

	

	

	
}
