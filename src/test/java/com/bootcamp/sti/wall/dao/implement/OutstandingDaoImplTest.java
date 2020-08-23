package com.bootcamp.sti.wall.dao.implement;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.bootcamp.sti.wall.dao.OutstandingDao;
import com.bootcamp.sti.wall.dto.OutstandingDto;
import com.bootcamp.sti.wall.model.Outstanding;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OutstandingDaoImplTest {
	Outstanding os = new Outstanding();
	OutstandingDto dto = new OutstandingDto();

	@Autowired
	private OutstandingDao od;
	@Autowired
	private TestEntityManager em;
	

	@Test
	public void testSetData() {
		dto.setIdOutstanding(3);
		dto.setOutstandingData(7000);
		dto.setDate(new Date(1998,11,11));
		assertNotNull(od.setData(dto));
	}


	@Test
	public void testGetListAll() {
		assertNotNull(od.getListAll());
	}

}
