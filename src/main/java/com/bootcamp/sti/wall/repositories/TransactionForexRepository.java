package com.bootcamp.sti.wall.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bootcamp.sti.wall.model.TransactionForex;

public interface TransactionForexRepository extends CrudRepository<TransactionForex, String>{

	List<TransactionForex> getByIdTraderIdTrader(String idTrader);

	@Query("FROM TransactionForex WHERE idTrader.idTrader = :idTrader ORDER BY transaction_date ASC")
	List<TransactionForex> getByIdTraderAscDate(@Param("idTrader")String idTrader1);
	
	List<TransactionForex> getByBuySell(String buySell);
	
	List<TransactionForex> getByDate(Date date);
}