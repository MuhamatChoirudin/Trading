package com.bootcamp.sti.wall.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bootcamp.sti.wall.model.Currency;


public interface CurrencyRepository  extends CrudRepository<Currency, String> {
	List<Currency> findByDescription(String description);
}
