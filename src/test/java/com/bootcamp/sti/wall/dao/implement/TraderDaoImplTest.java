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

import com.bootcamp.sti.wall.dao.TraderDao;
import com.bootcamp.sti.wall.dto.TraderDto;
import com.bootcamp.sti.wall.exception.EntityNotFoundException;
import com.bootcamp.sti.wall.model.Currency;
import com.bootcamp.sti.wall.model.Customer;
import com.bootcamp.sti.wall.model.StatusType;
import com.bootcamp.sti.wall.model.Trader;
@RunWith(SpringRunner.class)
@DataJpaTest
public class TraderDaoImplTest {
	Trader trader = new Trader();
	TraderDto trader2 = new TraderDto();
	Customer customer = new Customer();
	StatusType stype = new StatusType();
	
	@Autowired
	private TestEntityManager em;
	
	@Autowired
	private TraderDao trad;
	
	@Before
	public void setData() {
		
		
		
		for (int i = 1; i < 5; i++) {
			customer.setCif(String.format("cus0009%s",i));
			em.merge(customer);
			trader.setIdTrader(String.format("90%s", i));
			trader.setNameTrader(String.format("aye%s", i));
			trader.setBalance(i+000);
			trader.setCustomer(customer);
			
			em.merge(trader);
		}
	}
	
	@Test
	public void testCreate() {
		TraderDto dto = new TraderDto();
		customer.setCif("cus0009");
		em.merge(customer);
		stype.setIdStatusType(1);
		em.merge(stype);
		dto.setIdTrader("9006");
		dto.setNameTrader("ayeaye");
		dto.setBalance(7000);
		dto.setCustomer(customer);
		dto.setIdStatusType(stype);
		
		assertNotNull(trad.create(dto));
		assertEquals("9006", dto.getIdTrader());
	}

	

	@Test
	public void testGetByIdTrader() {
		assertNotNull(trad.getByIdTrader("901"));
	}

	@Test
	public void testGetBalance() {
		assertNotNull(trad.getBalance("902"));
	}



	@SuppressWarnings("deprecation")
	@Test
	public void testUpdateBalance() {
		assertNotNull(trad.updateBalance("901", 20000));
		Trader data = trad.getByIdTrader("901");
		assertEquals(20000, data.getBalance(), 1);
	}
	
	@Test
	public void testCredit() {
		trad.creditTrader("901", 20000);
		Trader neq = trad.getByIdTrader("901");
		assertNotNull(neq);
	}

	@Test
	public void testGetTraderByCif() {
	assertNotNull(trad.getTraderByCif("cus00091"));
	}


	@Test
	public void testSetData() {
		customer.setCif("cus0009");
		em.merge(customer);
		trader2.setIdTrader("90%s");
		trader2.setNameTrader("ayes");
		trader2.setBalance(7000);
		trader2.setCustomer(customer);
		assertNotNull(trad.setData(trader2));
	}

	@Test
	public void testGetAll() {
		assertNotNull(trad.getAll());
	}

	@Test
	public void testGetlistTrader() {
		assertNotNull(trad.getlistTrader());
		
	}
	
	@Test
	public void testDebit() {
		trad.creditTrader("904", 200);
		Trader neq = trad.getByIdTrader("904");
		assertNotNull(neq);
	}

}
