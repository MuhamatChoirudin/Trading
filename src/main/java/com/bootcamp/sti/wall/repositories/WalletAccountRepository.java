package com.bootcamp.sti.wall.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bootcamp.sti.wall.model.WalletAccount;

public interface WalletAccountRepository extends CrudRepository<WalletAccount, String>{
	WalletAccount findByAccountAccountNumber(String accountNumber);
}
