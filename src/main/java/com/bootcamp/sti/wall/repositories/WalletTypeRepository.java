package com.bootcamp.sti.wall.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bootcamp.sti.wall.model.WalletType;

public interface WalletTypeRepository extends CrudRepository<WalletType, Integer>{
WalletType findByDescription(String description);
}
