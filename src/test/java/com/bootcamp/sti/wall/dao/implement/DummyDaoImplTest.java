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

import com.bootcamp.sti.wall.dao.DummyDao;
import com.bootcamp.sti.wall.dto.CustomerDto;
import com.bootcamp.sti.wall.dto.DummyDto;
import com.bootcamp.sti.wall.model.Account;
import com.bootcamp.sti.wall.model.Dummy;
@RunWith(SpringRunner.class)
@DataJpaTest
public class DummyDaoImplTest {
	@Autowired
	private TestEntityManager em;
	
	@Autowired
	private DummyDao dum;
	Dummy dummy = new Dummy();
	@Before
	public void setData() {
		
		for (int i = 1; i < 5; i++) {
			
			dummy.setIdDummy( i);
			dummy.setName(String.format("account%s",i));
			dummy.setBalance(i+0000);
			em.merge(dummy);
		}
	}
	@Test
	public void testCreateDummy() {
		Dummy dummy = new Dummy();
		dummy.setIdDummy(10);
		dummy.setName("admin");
		dummy.setBalance(20000);
		
		assertNotNull(dum.createDummy(dummy));
		
	}
	
	@Test
	public void testUpdateDummy() {
		 dum.updateBalance("account1", 200000);
		
		
		
	}	

	@Test
	public void testGetBalance() {
		
		assertNotNull(dum.getBalance("account1"));
	}

	@Test
	public void testUpdateBalance() {
		Dummy dummy = dum.updateBalance("account1", 2003);
		assertEquals("account1",dummy.getName());
	}

	   


}
