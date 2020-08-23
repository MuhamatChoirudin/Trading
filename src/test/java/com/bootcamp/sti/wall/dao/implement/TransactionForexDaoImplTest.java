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

import com.bootcamp.sti.wall.dao.TransactionForexDao;
import com.bootcamp.sti.wall.dto.TransactionForexDto;
import com.bootcamp.sti.wall.exception.BalanceNotEnoughException;
import com.bootcamp.sti.wall.model.Currency;
import com.bootcamp.sti.wall.model.Trader;
import com.bootcamp.sti.wall.model.TransactionForex;
@RunWith(SpringRunner.class)
@DataJpaTest
public class TransactionForexDaoImplTest {
	TransactionForex transForex = new TransactionForex();
	Currency cur = new Currency();
	Trader trad = new Trader();
	@Autowired
	private TestEntityManager em;
	@Autowired
	private TransactionForexDao tf;
	@Before
	public void setData() {
		
		for (int i = 1; i < 5; i++) {
			cur.setIdCurrency(1);
			em.merge(cur);
			trad.setIdTrader("22");
			em.merge(trad);
			transForex.setIdTransactionForex(i);
			transForex.setIdTrader(trad);
			transForex.setAmount(2455);
			transForex.setAmountAfterSell(789+i);
			transForex.setBuySell("buy");
			transForex.setCurrency(cur);
			transForex.setDate(new Date(199,10,11));
			transForex.setPointLose(2345);
			transForex.setPotensialPoinLose(25);
			transForex.setRate(244);
			assertNotNull(tf.save(transForex));
	
		}
	}
	
	
	@Test
	public void testSetData() {
		
		cur.setIdCurrency(1);
		em.merge(cur);
		trad.setIdTrader("22");
		em.merge(trad);
		
		transForex.setIdTransactionForex(13);
		transForex.setIdTrader(trad);
		transForex.setAmount(2455);
		transForex.setAmountAfterSell(789);
		transForex.setBuySell("buy");
		transForex.setCurrency(cur);
		transForex.setDate(new Date(1998,11,11));
		transForex.setPointLose(2345);
		transForex.setPotensialPoinLose(25);
		transForex.setRate(244);
		assertNotNull(tf.save(transForex));
	}
	
	@Test
	public void testGetForex() {
		assertNotNull(tf.getTransForex());
	}
	@Test
	public void testGetForexList() {
		assertNotNull(tf.getByDate(new Date(1998,11,11)));
	}
	@Test
	public void testGetForexAmount() {
		cur.setIdCurrency(1);
		em.merge(cur);
		trad.setIdTrader("23");
		em.merge(trad);
		
		transForex.setIdTransactionForex(131);
		transForex.setIdTrader(trad);
		transForex.setAmount(24551);
		transForex.setAmountAfterSell(7189);
		transForex.setBuySell("buy");
		transForex.setCurrency(cur);
		transForex.setDate(new Date(1948,10,12));
		transForex.setPointLose(2345);
		transForex.setPotensialPoinLose(25);
		transForex.setRate(244);
		assertNotNull(tf.save(transForex));
		
	}
	
	@Test
	public void testGetList() {
		assertNotNull(tf.getByIdTraderAscDate("22"));
	}
	
	@Test
	public void testGetList2() {
		assertNotNull(tf.getByIdTrader("22"));
	}
	
	@Test
	public void testGetList3() {
		assertNotNull(tf.getAmountForex("23"));
	}
	
	@Test
	public void testBuy() throws BalanceNotEnoughException {
		TransactionForexDto transForex1 = new TransactionForexDto();
		cur.setIdCurrency(1);
		em.merge(cur);
		trad.setIdTrader("22");
		em.merge(trad);
		
		transForex1.setIdTransactionForex(13);
		transForex1.setIdTrader(trad);
		transForex1.setAmount(2455);
		transForex1.setAmountAfterSell(789);
		transForex1.setBuySell("buy");
		transForex1.setCurrency(cur);
		transForex1.setDate(new Date(1998,11,11));
		transForex1.setPointLose(2345);
		transForex1.setPotensialPoinLose(25);
		transForex1.setRate(244);
		assertNotNull(tf.setData(transForex1));
	}
}
