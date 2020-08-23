package com.bootcamp.sti.wall.dao;

import java.util.List;

import com.bootcamp.sti.wall.dto.WalletAccountDto;
import com.bootcamp.sti.wall.model.WalletAccount;


public interface WalletAccountDao {
	List<WalletAccount> getListWalletAccount(String cif) ;
	WalletAccount registerWalletAccount(WalletAccountDto wallet);
	WalletAccount updateWalletAccount(WalletAccountDto wallet);
	WalletAccount getWalletAccountByAccountNumber(String accountNumber);
}
