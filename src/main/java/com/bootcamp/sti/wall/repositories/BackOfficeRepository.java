package com.bootcamp.sti.wall.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bootcamp.sti.wall.model.BackOffice;

public interface BackOfficeRepository extends CrudRepository<BackOffice, String> {

	BackOffice findByIdUserIdUser(String idUser);
}
