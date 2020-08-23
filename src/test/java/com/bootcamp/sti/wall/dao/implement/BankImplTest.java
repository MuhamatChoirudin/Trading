package com.bootcamp.sti.wall.dao.implement;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.bootcamp.sti.wall.dao.BankDao;
import com.bootcamp.sti.wall.dto.BankDto;
import com.bootcamp.sti.wall.model.Bank;
@RunWith(SpringRunner.class)
@DataJpaTest
public class BankImplTest {
	BankDto bank = new BankDto();
	@Autowired
	private TestEntityManager em;
	
	@Autowired
	private BankDao bankDao;
	
	@Before
	public void setData() {
		
		for (int i = 1; i < 5; i++) {
			
			bank.setIdBank(String.format("1%s", i));
			
			bank.setName(String.format("account%s",i));
			bank.setBalance(i + 00000);
			
			
			bankDao.createBank(bank);
		}
	}
	@Test
	public void testCreateBank() {
		
		bank.setName("saya");
		bank.setBalance(400000);
		
		assertNotNull(bankDao.createBank(bank));
		
		
	}

	@Test
	public void testGetList() {
		assertNotNull(bankDao.getListBank());
	}

	@Test
	public void testSetData() {
		bank.setIdBank("2563");
		bank.setName("hjkk");
		bank.setBalance(1235);
		assertNotNull(bankDao.setData(bank));
	}
}
