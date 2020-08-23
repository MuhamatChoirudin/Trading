package com.bootcamp.sti.wall.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bootcamp.sti.wall.model.Trader;

public interface TraderRepository extends CrudRepository<Trader, String>{
Trader findByCustomerCif(String cif);
}
