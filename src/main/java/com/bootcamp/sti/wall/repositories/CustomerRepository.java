package com.bootcamp.sti.wall.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bootcamp.sti.wall.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String> {

	Customer findByIdUserIdUser(String idUser);

	Customer findByCif(String cif2);

	Customer findFirstByOrderByCountCifDesc();

	Customer findByIdCard(String idCard);

}
