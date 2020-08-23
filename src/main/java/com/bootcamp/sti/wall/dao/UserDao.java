package com.bootcamp.sti.wall.dao;

import com.bootcamp.sti.wall.dto.UserDto;
import com.bootcamp.sti.wall.exception.EntityNotFoundException;
import com.bootcamp.sti.wall.exception.UserException;
import com.bootcamp.sti.wall.model.User;

public interface UserDao {
	User getByUsernamePassword(String username, String password) throws EntityNotFoundException;

	User createUser(UserDto user);
	User getByUsername(String username) throws UserException;
	
}
