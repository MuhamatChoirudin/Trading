package com.bootcamp.sti.wall.dao;


import java.util.List;

import com.bootcamp.sti.wall.dto.TraderDto;
import com.bootcamp.sti.wall.exception.BalanceNotEnoughException;
import com.bootcamp.sti.wall.model.Trader;

public interface TraderDao {
	Trader getTraderByCif(String cif);
	Trader create(TraderDto trader);
	Trader update(TraderDto trader);
	Trader getByIdTrader(String cif);
	double getBalance (String idTrader);
	Trader updateBalance (String idTrader, double result);
	void sell (String idTrader, double amount);
	double buy ( String idTrader, double amount)throws BalanceNotEnoughException;
	void creditTrader (String idTrader, double amount);
	void debitTrader (String idTrader, double amount);
	Iterable<Trader> getAll();
	List<Trader> getlistTrader();
	Trader setData(TraderDto dto);
}

