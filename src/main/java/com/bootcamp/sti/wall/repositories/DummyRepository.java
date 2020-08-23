package com.bootcamp.sti.wall.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bootcamp.sti.wall.model.Dummy;

public interface DummyRepository extends CrudRepository<Dummy, String>{
	Dummy findByName(String dummy);
}
