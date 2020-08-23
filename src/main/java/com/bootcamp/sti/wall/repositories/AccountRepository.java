package com.bootcamp.sti.wall.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bootcamp.sti.wall.model.Account;

public interface AccountRepository extends CrudRepository<Account, String>{
Account findByCashtag(String cashtag);
}
