package com.bootcamp.sti.wall.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bootcamp.sti.wall.model.Outstanding;

public interface OutstandingRepository extends CrudRepository<Outstanding, String>{

	List<Outstanding> findByIdTraderIdTrader(String idTrader);
}
