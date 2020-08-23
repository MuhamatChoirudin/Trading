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

import com.bootcamp.sti.wall.dao.CustomerDao;
import com.bootcamp.sti.wall.dto.CustomerDto;
import com.bootcamp.sti.wall.exception.EntityNotFoundException;
import com.bootcamp.sti.wall.model.Customer;
import com.bootcamp.sti.wall.model.Image;
import com.bootcamp.sti.wall.model.User;
import com.bootcamp.sti.wall.repositories.CustomerRepository;
@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerDaoImplTest {
	Customer customer = new Customer();
	CustomerDto cus = new CustomerDto();
	User user = new User();
	Image image = new Image();
	
	@Autowired
	private TestEntityManager em;
	@Autowired
	private CustomerRepository cr;
	@Autowired
	private CustomerDao customerDao;
	
	@Before
	public void setData() {
		

		for (int i = 1; i < 5; i++) {
			customer.setCif(String.format("4000%s", i));
			customer.setFirstName(String.format("customer%s",i));
			customer.setLastName(String.format("wallx%s",i));
			customer.setBirthDate(new Date(1998,11,11));
			customer.setGender(String.format("Laki%s",i));
			customer.setAddress(String.format("Jakarta%s",i));
			customer.setMother(String.format("Ibu%s",i));
			customer.setIdCard(String.format("2009%s",i));
			customer.setPhone(String.format("112009%s",i));
			customer.setSalary(String.format("9009%s",i));
			customer.setOccupation(String.format("guru%s",i));
			user.setIdUser("1");
			em.merge(user);
			cus.setIdUser(user);
			
			em.merge(customer);
		}
	}
	

	@Test
	public void testCreateCustomer() throws EntityNotFoundException {
		cus.setCif("40023");
		cus.setFirstName("Dada");
		cus.setLastName("Kura");
		cus.setBirthDate(new Date(1998,11,11));
		cus.setGender("Laki");
		cus.setAddress("Jakarta");
		cus.setMother("Ibu%");
		cus.setIdCard("20077");
		cus.setPhone("100909");
		cus.setSalary("9009000");
		cus.setOccupation("guru");

		assertNotNull(customerDao.createCustomer(cus));
		assertEquals("20077", cus.getIdCard());
	}

	@Test
	public void testGetByCustomerId() {
		assertNotNull(customerDao.getByCustomerId("40002"));
	}

	@Test
	public void testGetByIdcard() {
		assertNotNull(customerDao.getByIdcard("20091"));
	}

	@Test
	public void testSetData() {
		cus.setCif("40023");
		cus.setFirstName("Dada");
		cus.setLastName("Kura");
		cus.setBirthDate(new Date(1998,11,11));
		cus.setGender("Laki");
		cus.setAddress("Jakarta");
		cus.setMother("Ibu%");
		cus.setIdCard("20077");
		cus.setPhone("100909");
		cus.setSalary("9009000");
		cus.setOccupation("guru");
		image.setIdImage(1);
		em.merge(image);
		cus.setIdImage(image);
		user.setIdUser("1");
		em.merge(user);
		cus.setIdUser(user);
		assertNotNull(customerDao.setData(cus));
	}

}
