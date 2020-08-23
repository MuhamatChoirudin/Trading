package com.bootcamp.sti.wall.dao.implement;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.bootcamp.sti.wall.dao.CustomerDao;
import com.bootcamp.sti.wall.dto.CustomerDto;
import com.bootcamp.sti.wall.exception.EntityNotFoundException;
import com.bootcamp.sti.wall.model.Customer;
import com.bootcamp.sti.wall.repositories.CustomerRepository;
import com.bootcamp.sti.wall.repositories.UserRepository;

public class CustomerDaoImpl implements CustomerDao {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private CustomerRepository cr;

	@Autowired
	private UserRepository ur;

	@Override
	public Customer getByIdUser(String idUser) {
		return cr.findByIdUserIdUser(idUser);
	}

	@Override
	@Transactional
	public Customer createCustomer(CustomerDto cust) throws EntityNotFoundException{
		Customer customer = setData(cust);
		int countCif = 0;
		
		if (ur.findByIdUser(customer.getIdUser().getIdUser()) == null) {
			throw new EntityNotFoundException();
		} else {
			Customer getCif = cr.findFirstByOrderByCountCifDesc();
			if (getCif == null) {
				String cif = "6660100001";
				countCif = Integer.valueOf(cif.substring(5, cif.length()));
				customer.setCif(cif);
				customer.setCountCif(countCif);
			} else {
				int tempCounterCif = getCif.getCountCif();
				int newCounterCif = tempCounterCif + 1;
				String cif = "66601" + String.format("%05d", newCounterCif);
				customer.setCif(cif);
				customer.setCountCif(newCounterCif);
			}
		}
		
		return cr.save(customer);

	}

	@Override
	public Customer getByCustomerId(String id) {
		return em.find(Customer.class, id);
	}

	@Override
	public Customer getByIdcard(String idCard) {
		return cr.findByIdCard(idCard);
	}
	@Override
	public Customer setData(CustomerDto dto) {
		Customer cus = new Customer();
		cus.setAddress(dto.getAddress());
		cus.setBirthDate(dto.getBirthDate());
		cus.setFirstName(dto.getFirstName());
		cus.setGender(dto.getGender());
		cus.setIdCard(dto.getIdCard());
		cus.setIdImage(dto.getIdImage());
		cus.setIdUser(dto.getIdUser());
		cus.setLastName(dto.getLastName());
		cus.setMother(dto.getMother());
		cus.setOccupation(dto.getOccupation());
		cus.setPhone(dto.getPhone());
		cus.setSalary(dto.getSalary());
		
		return cus;
	}
}
