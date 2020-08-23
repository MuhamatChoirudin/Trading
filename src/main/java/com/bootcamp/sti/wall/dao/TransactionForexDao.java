package com.bootcamp.sti.wall.dao;

import java.util.Date;
import java.util.List;

import com.bootcamp.sti.wall.dto.TransactionForexDto;
import com.bootcamp.sti.wall.exception.BalanceNotEnoughException;
import com.bootcamp.sti.wall.model.TransactionForex;

public interface TransactionForexDao {
	TransactionForex buy(TransactionForexDto transactionForex) throws BalanceNotEnoughException;
	List<TransactionForex> getByIdTrader(String idTrader);
	List<TransactionForex> getByIdTraderAscDate(String idTrader);
	TransactionForex newSell(TransactionForexDto transactionForex) throws BalanceNotEnoughException;
	List<TransactionForex> getTransForex();
	double getAmountForex(String idTrader);
	List<TransactionForex> getByDate(Date date);
	TransactionForex save(TransactionForex transForex);
	TransactionForex setData(TransactionForexDto dto);
}
