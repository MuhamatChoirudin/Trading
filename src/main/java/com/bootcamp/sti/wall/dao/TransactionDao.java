package com.bootcamp.sti.wall.dao;

import java.util.List;

import com.bootcamp.sti.wall.dto.TransactionDto;
import com.bootcamp.sti.wall.model.Transaction;

public interface TransactionDao {
	Transaction setData(TransactionDto dto);
	Transaction createTransaction(TransactionDto transaction);
	List<Transaction> getTransactionsByAccountNumber(String accountNumberCredit, String accountNumberDebit);
}
