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

import com.bootcamp.sti.wall.dao.WalletAccountDao;
import com.bootcamp.sti.wall.dto.WalletAccountDto;
import com.bootcamp.sti.wall.model.Account;
import com.bootcamp.sti.wall.model.Customer;
import com.bootcamp.sti.wall.model.WalletAccount;
import com.bootcamp.sti.wall.model.WalletType;
@RunWith(SpringRunner.class)
@DataJpaTest
public class WalletAccountImplTest {
	
	WalletAccountDto waconn = new WalletAccountDto();
	Customer customer = new Customer();
	Account account = new Account();
	WalletType wallet = new WalletType();
	@Autowired
	private WalletAccountDao waDao;
	
	@Autowired
	private TestEntityManager em;
	@Before
	public void setData() {
		
		
		customer.setCif("cus0009");
		em.merge(customer);
		for (int i = 1; i < 5; i++) {
			waconn.setIdWallet(String.format("90%s", i));
			
			account.setAccountNumber(String.format("9%s", i));
			em.merge(account);
			
			waconn.setAccount(account);
			waconn.setCustomer(customer);
			waconn.setOpenDate(new Date(1998,11,11));
			
			waDao.registerWalletAccount(waconn);
		}
	}
	@Test
	public void testCreateAccount() {
		WalletAccountDto wltAccDto = new WalletAccountDto();
		wltAccDto.setIdWallet("100");
		account.setAccountNumber("91");
		wltAccDto.setAccount(account);
		customer.setCif("cus0009");
		wltAccDto.setCustomer(customer);
		wltAccDto.setOpenDate(new Date(1998,11,11));
		assertNotNull(waDao.registerWalletAccount(wltAccDto));
	}


	@Test
	public void testGetList() {
		assertNotNull(waDao.getListWalletAccount("cus0009"));
	}

	@Test
	public void testGetByAccountId() {

		assertNotNull(waDao.getWalletAccountByAccountNumber("91"));
	}
	
	@Test
	public void testupdate() {
		WalletAccountDto wltAccDto = new WalletAccountDto();
		wltAccDto.setIdWallet("901");
		account.setAccountNumber("91");
		wltAccDto.setAccount(account);
		customer.setCif("cus0009");
		wltAccDto.setCustomer(customer);
		wltAccDto.setOpenDate(new Date(1998,11,11));
		assertNotNull(waDao.updateWalletAccount(wltAccDto));
	}

	@Test
	public void testGetListWalletAccount() {
		assertNotNull(waDao.getListWalletAccount("cus0009"));
	}

	@Test
	public void testRegisterWalletAccount() {
		WalletAccountDto waconn = new WalletAccountDto();
		Customer customer = new Customer();
		Account account = new Account();
		WalletType wallet = new WalletType();	
		waconn.setIdWallet("100");
		waconn.setAccount(account);
		waconn.setCustomer(customer);
		waconn.setOpenDate(new Date(1998,11,11));
		assertNotNull(waDao.registerWalletAccount(waconn));
	}

}
