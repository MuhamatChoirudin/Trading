package com.bootcamp.sti.wall.dao;

import com.bootcamp.sti.wall.dto.CustomerDto;
import com.bootcamp.sti.wall.exception.EntityNotFoundException;
import com.bootcamp.sti.wall.model.Customer;

public interface CustomerDao {
	Customer getByIdUser(String idUser);

	Customer createCustomer(CustomerDto customer) throws EntityNotFoundException;

	Customer getByCustomerId(String id);

	Customer getByIdcard(String idCard);
	
	Customer setData(CustomerDto dto);
}
