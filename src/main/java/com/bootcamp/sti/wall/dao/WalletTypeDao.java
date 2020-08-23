package com.bootcamp.sti.wall.dao;

import java.util.List;

import com.bootcamp.sti.wall.dto.WalletTypeDto;
import com.bootcamp.sti.wall.model.WalletType;

public interface WalletTypeDao {
	List<WalletType> getListWalletType() ;
	WalletType createWalletType (WalletTypeDto walletType);
	WalletType getWalletByDescription(String name);
	WalletType setData(WalletTypeDto dto);
}
