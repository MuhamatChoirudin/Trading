package com.bootcamp.sti.wall.dao;

import java.util.List;

import com.bootcamp.sti.wall.dto.BankDto;
import com.bootcamp.sti.wall.model.Bank;

public interface BankDao {
	List<Bank> getListBank() ;
	Bank createBank(BankDto bank);
	double getBalance(String idBank);
	Bank updateBalance(String idBank, double result);
	void creditBank (String idBank, double amount);
	void debitBank (String idBank, double amount);
	Bank getByIdBank (String idBank);
	 Bank setData(BankDto dto);

}
