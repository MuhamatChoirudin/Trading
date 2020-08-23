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

import com.bootcamp.sti.wall.dao.UserDao;
import com.bootcamp.sti.wall.dto.RoleTypeDto;
import com.bootcamp.sti.wall.dto.UserDto;
import com.bootcamp.sti.wall.exception.EntityNotFoundException;
import com.bootcamp.sti.wall.exception.UserException;
import com.bootcamp.sti.wall.model.RoleType;
import com.bootcamp.sti.wall.model.User;
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserImplTest {
	
	
	@Autowired
	private TestEntityManager em;
	@Autowired
	private UserDao us;
	UserDto user = new UserDto();
	User user3 = new User();
	RoleType rol = new RoleType();


	@Test
	public void testCreateCustomer() {
		
		rol.setIdRoleType(1);
		rol.setDescription("user");
		em.merge(rol);
	
		user.setIdUser("400199");
		user.setPassword("pass");
		user.setUsername("user");
		user.setIdRoleType(rol);
		user.setRegisterDate(new Date(1998,11,11));
		assertNotNull(us.createUser(user));
		
	}

	@Test
	public void testGetUserByUsername()throws EntityNotFoundException {
	
		user3.setIdUser("400198");
		user3.setPassword("pass1");
		user3.setUsername("user1");
		user3.setRegisterDate(new Date(1998,11,11));
		em.merge(user3);
		User use2 = us.getByUsernamePassword("user1", "pass1");
		assertEquals("400198", use2.getIdUser());
	}
	
	@Test
	public void testGetUserByName() throws UserException {
		user3.setIdUser("400197");
		user3.setPassword("pass2");
		user3.setUsername("user2");
		user3.setRegisterDate(new Date(1998,11,11));
		em.merge(user3);
	User uss = us.getByUsername("user2");
	assertNotNull(uss);
	}
	
	

}
