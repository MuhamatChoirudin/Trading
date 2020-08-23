package com.bootcamp.sti.wall.dao;

import java.util.List;

import com.bootcamp.sti.wall.dto.AccountDto;
import com.bootcamp.sti.wall.model.Account;

public interface AccountDao {
List<Account> getListAccount(String cif) ;
List<Account> getListAccount() ;
Account createAccount(AccountDto account);
Account getByAccountNumber(String accountNumber) ;
Account getByCashtag(String cashtag) ;
Account updateAccount(AccountDto account);
double getBalance(String accountNumber);
Account updateBalance(String accountNumber, double result);
void creditAccount (String accountNumber, double amount);
void debitAccount (String accountNumber, double amount);
}
