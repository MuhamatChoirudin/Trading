package com.bootcamp.sti.wall.dto;

import java.util.Date;

public class WalletTypeDto {

	private int idWalletType;
	private String description;
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
