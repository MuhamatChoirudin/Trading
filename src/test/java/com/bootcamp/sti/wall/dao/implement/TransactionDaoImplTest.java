package com.bootcamp.sti.wall.dao.implement;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.bootcamp.sti.wall.dao.TransactionDao;
import com.bootcamp.sti.wall.dto.TransactionDto;
import com.bootcamp.sti.wall.dto.TransactionForexDto;
import com.bootcamp.sti.wall.model.Bank;
import com.bootcamp.sti.wall.model.Transaction;
import com.bootcamp.sti.wall.model.TransactionType;
@RunWith(SpringRunner.class)
@DataJpaTest
public class TransactionDaoImplTest {

	TransactionDto tran = new TransactionDto();
	Bank bank = new Bank();
	Transaction trans = new Transaction();
	TransactionType trantype = new TransactionType();
	
	@Autowired
	private TestEntityManager em;
	@Autowired
	private TransactionDao td;
	
	@Before
	public void setData() {
		for (int i = 1; i < 5; i++) {
		bank.setIdBank("cus0009");
		em.merge(bank);
		trantype.setIdTransactionType("2");
		em.merge(trantype);
		tran.setAccountCredit(String.format("4000%s", i));
		tran.setAccountDebit("209");
		tran.setAmount(100);
		tran.setDescription("Topup");
		tran.setDate(new Date(1998,11,11));
		tran.setBank(bank);
		tran.setIdTransaction(String.format("4400%s", i));
		//tran.setTransactionType(trantype);
		 td.createTransaction(tran);
		}
		
	}
	@Test
	public void testCreateTransaction() {
		
		bank.setIdBank("cus0009");
		em.merge(bank);
		trantype.setIdTransactionType("1");
		em.merge(trantype);
		tran.setAccountCredit("202");
		tran.setAccountDebit("209");
		tran.setAmount(1000);
		tran.setDescription("Topup");
		tran.setDate(new Date(1998,11,11));
		tran.setBank(bank);
		tran.setIdTransaction("10005");
		tran.setTransactionType(trantype);
		assertNotNull(td.createTransaction(tran));
		
		
	}

	@Test
	public void testGetTransactionsByAccountNumber() {
		assertNotNull(td.getTransactionsByAccountNumber("202", "209"));
	}

	@Test
	public void testSetData() {
		
		bank.setIdBank("cus0009");
		em.merge(bank);
		trantype.setIdTransactionType("1");
		em.merge(trantype);
		tran.setAccountCredit("202");
		tran.setAccountDebit("209");
		tran.setAmount(1000);
		tran.setDescription("Topup");
		tran.setDate(new Date(1998,11,11));
		tran.setBank(bank);
		tran.setIdTransaction("10005");
		tran.setTransactionType(trantype);
		assertNotNull(td.setData(tran));
		
		
	}

}
