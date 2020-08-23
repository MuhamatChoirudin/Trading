package com.bootcamp.sti.wall.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.sti.wall.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	User findByUsernameAndPassword(String username, String password);

	User findByIdUser(String idUser);

	User findByUsername(String username);

}
