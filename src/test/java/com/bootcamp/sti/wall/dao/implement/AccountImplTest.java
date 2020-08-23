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

import com.bootcamp.sti.wall.dao.AccountDao;
import com.bootcamp.sti.wall.dto.AccountDto;
import com.bootcamp.sti.wall.exception.EntityNotFoundException;
import com.bootcamp.sti.wall.model.Account;
import com.bootcamp.sti.wall.model.Customer;
import com.bootcamp.sti.wall.model.StatusType;
import com.bootcamp.sti.wall.repositories.AccountRepository;
@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountImplTest {
	Customer customer = new Customer();
	
	StatusType statusType = new StatusType();
	@Autowired
	private TestEntityManager em;
	
	@Autowired
	private AccountRepository ar;
	
	@Autowired
	private AccountDao accountDao;
	AccountDto account = new AccountDto();
	@Before
	public void setData() {
		
		customer.setCif("cus0009");
		em.merge(customer);
		for (int i = 1; i < 5; i++) {
			account.setAccountNumber(String.format("4000%s", i));
			account.setCashtag(String.format("account%s",i));
			account.setBalance(i + 00000);
			account.setCustomer(customer);
			account.setOpenDate(new Date(1998,11,11));
			
			assertNotNull(accountDao.createAccount(account));
		}
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testCreateAccount() {
		AccountDto account = new AccountDto();
		account.setCashtag("account7");
		account.setBalance(100000);
		account.setCustomer(customer);
		account.setOpenDate(new Date(1998,11,11));
		
		assertNotNull(accountDao.createAccount(account));
		assertEquals(100000,account.getBalance(),1);
	
	}


	@Test
	public void testGetByAccountId() throws EntityNotFoundException{
		assertNotNull(accountDao.getByAccountNumber("40001"));
		
	}
	@Test
	public void testGetByAccountId1(){
		Account account = accountDao.getByAccountNumber("40002");
		assertEquals("40002",account.getAccountNumber());
	}
	@Test
	public void testGetListParameter() {
		assertNotNull(accountDao.getListAccount("cus0009"));
	}
	
	@Test
	public void testGetList() {
		assertNotNull(accountDao.getListAccount());
	}
	
	@Test
	public void testGetByChastag() {
		assertNotNull(accountDao.getByCashtag("account1"));
	}
	

	@Test
	public void testGetByChastag2() {
		Account account = accountDao.getByCashtag("account1");
		assertEquals("account1",account.getCashtag());
	}
	
	

}
