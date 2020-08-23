package com.bootcamp.sti.wall.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bootcamp.sti.wall.model.Transaction;


public interface TransactionRepository extends CrudRepository<Transaction, Integer>{
List<Transaction> findByAccountCreditOrAccountDebit(String accountCredit, String accountDebit);
}
