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

import com.bootcamp.sti.wall.dao.CurrencyDao;
import com.bootcamp.sti.wall.dto.CurrencyDto;
import com.bootcamp.sti.wall.model.Account;
import com.bootcamp.sti.wall.model.Currency;
@RunWith(SpringRunner.class)
@DataJpaTest
public class CurrencyImplTest {
	
	@Autowired
	private CurrencyDao currencyDao;
	CurrencyDto currency = new CurrencyDto();
	@Before
	public void setData() {
	
		for (int i = 1; i < 5; i++) {
			currency.setIdCurrency(i);
			currency.setCcyDestination(String.format("account%s",i));
			currency.setCcyBase("Idr");
			currency.setBuy(i+000);
			currency.setSell(i+000);
			currency.setDate(new Date(1998,11,11));
			currency.setDescription("jual");
			
			currencyDao.createCurrency(currency);
			
		}
	}
	@Test
	public void testGetList() {
		assertNotNull(currencyDao.getListCurrency("jual"));
	}

	@Test
	public void testCreateCurrency() {
		CurrencyDto currency = new CurrencyDto();
		currency.setIdCurrency(99);
		currency.setCcyDestination("use");
		currency.setCcyBase("Idr");
		currency.setBuy(2000);
		currency.setSell(4000);
		currency.setDate(new Date(1998,11,11));
		currency.setDescription("jual");
		
		assertNotNull(currencyDao.createCurrency(currency));
	}
	@Test
	public void testGetBuy() {
		
		assertNotNull(currencyDao.getBuy());
	}
	@Test
	public void testGetSell() {
		
		assertNotNull(currencyDao.getSell());
	}
	@Test
	public void testGetCurrency() {
		
		assertNotNull(currencyDao.getCurrency());
	}
	

	
	
}
