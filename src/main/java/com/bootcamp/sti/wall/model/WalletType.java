package com.bootcamp.sti.wall.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="WalletType")
@Table(name="tb_wallet_type")
public class WalletType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_wallet_type")	
	private int idWalletType;
	
	@Column(name="description")
	private String description;
	
	@Column(name="open_date")
	private Date openDate;

	
	
	public int getIdWalletType() {
		return idWalletType;
	}
	public void setIdWalletType(int idWalletType) {
		this.idWalletType = idWalletType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	
	
}
