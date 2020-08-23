package com.bootcamp.sti.wall.dao.implement;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.bootcamp.sti.wall.dao.TransactionDao;
import com.bootcamp.sti.wall.dto.TransactionDto;
import com.bootcamp.sti.wall.model.Transaction;
import com.bootcamp.sti.wall.repositories.TransactionRepository;

public class TransactionDaoImpl implements TransactionDao{

	@PersistenceContext
	EntityManager em;
	
	@Autowired
	TransactionRepository tr;
	
	@Override
	public Transaction createTransaction(TransactionDto transaction) {
		String id="";
		Query query = em.createQuery("FROM Transaction order by id_transaction desc");
        query.setMaxResults(1);
        if(query.getResultList().isEmpty()){
            id = "6600001";
        } else {
            Transaction trans = (Transaction) query.getSingleResult();
           String idtransaction= trans.getIdTransaction();
           int idd = Integer.parseInt(idtransaction)+1;
            id=String.valueOf(idd);
        }
        Transaction trans = setData(transaction);
        trans.setIdTransaction(id);
		return tr.save(trans);	
	}
	
	@Override
	public List<Transaction> getTransactionsByAccountNumber(String accountCredit, String accountDebit) {
		return tr.findByAccountCreditOrAccountDebit(accountCredit, accountDebit);
	}
	@Override
	public Transaction setData(TransactionDto dto) {
		Transaction trans = new Transaction();
		trans.setAccountCredit(dto.getAccountCredit());
		trans.setAccountDebit(dto.getAccountDebit());
		trans.setAmount(dto.getAmount());
		trans.setBank(dto.getBank());
		trans.setDate(dto.getDate());
		trans.setDescription(dto.getDescription());
		trans.setTransactionType(dto.getTransactionType());
	
		return trans;
	}

}
