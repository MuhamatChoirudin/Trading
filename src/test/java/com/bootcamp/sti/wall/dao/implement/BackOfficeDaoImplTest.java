package com.bootcamp.sti.wall.dao.implement;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.bootcamp.sti.wall.dao.BackOfficeDao;
import com.bootcamp.sti.wall.model.BackOffice;
import com.bootcamp.sti.wall.model.User;
@RunWith(SpringRunner.class)
@DataJpaTest
public class BackOfficeDaoImplTest {
	@Autowired
	private TestEntityManager em;
	@Autowired
	private BackOfficeDao bd;
	@Test
	public void testGetByIdUser() {
		BackOffice bo = new BackOffice();
		User us = new User();
		
		us.setIdUser("364");
		em.merge(us);
		bo.setIdBackoffice("464");
		bo.setFirstname("gjkl");
		bo.setLastname("jhgjhk");
		bo.setIdUser(us);
		em.merge(bo);
		bd.getByIdUser("364");
	}

}
