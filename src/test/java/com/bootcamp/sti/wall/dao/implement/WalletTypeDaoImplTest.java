package com.bootcamp.sti.wall.dao.implement;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bootcamp.sti.wall.dao.WalletTypeDao;
import com.bootcamp.sti.wall.dto.WalletTypeDto;
import com.bootcamp.sti.wall.model.WalletType;
import com.bootcamp.sti.wall.repositories.WalletTypeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WalletTypeDaoImplTest {
	WalletType wallet = new WalletType();
	WalletTypeDto ww = new WalletTypeDto();
	@Autowired
	private WalletTypeDao walDao; 
	
	@Autowired
	private WalletTypeRepository wtr;
	
	@Before
	public void setData() {
		
		for (int i = 1; i < 5; i++) {
			
			wallet.setIdWalletType( i);
			
			wallet.setDescription(String.format("account%s",i));
			wallet.setOpenDate(new Date(1998,11,11));
			
			
			wtr.save(wallet);
		}
	}
	@Test
	public void testGetListWalletType() {
		assertNotNull(walDao.getListWalletType());
	}

	@Test
	public void testCreateWalletType() {
		ww.setIdWalletType( 999);
		
		ww.setDescription("hhhh");
		ww.setOpenDate(new Date(1998,11,11));
		
		assertNotNull(walDao.createWalletType(ww));
		
	
	}

	@Test
	public void testGetWalletByDescription() {
		assertNotNull(walDao.getWalletByDescription("account1"));
	}
	@Test
	public void testSetData() {
		ww.setIdWalletType( 999);		
		ww.setDescription("hhhh");
		ww.setOpenDate(new Date(1998,11,11));
		
		assertNotNull(walDao.setData(ww));
		
	
	}

}
