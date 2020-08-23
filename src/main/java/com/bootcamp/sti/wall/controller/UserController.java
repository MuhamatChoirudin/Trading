package com.bootcamp.sti.wall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.sti.wall.dao.UserDao;
import com.bootcamp.sti.wall.dto.CommonResponse;
import com.bootcamp.sti.wall.dto.UserDto;
import com.bootcamp.sti.wall.exception.EntityNotFoundException;
import com.bootcamp.sti.wall.exception.UserException;
import com.bootcamp.sti.wall.model.User;

@CrossOrigin
@RestController
public class UserController {
	public static final String URL_USER = "user";
	public static final String URL_LOGIN = "login";
	public static final String URL_REGISTRATION = "registration";

	@Autowired
	private UserDao userService;

	@PostMapping(value = URL_USER + "/" + URL_LOGIN)
	public CommonResponse<User> login(@RequestBody UserDto user) throws EntityNotFoundException {
		CommonResponse<User> resp = new CommonResponse<>();
		String userTemp = user.getUsername();
		String passTemp = user.getPassword();

		resp.setData(userService.getByUsernamePassword(userTemp, passTemp));

		return resp;

	}

	@PostMapping(value = URL_USER + "/" + URL_REGISTRATION)
	public CommonResponse<User> createCustomer(@RequestBody UserDto user) {
		CommonResponse<User> us = new CommonResponse<>();
		us.setData(userService.createUser(user));
		return us;
	}

	@GetMapping(value = URL_USER)
	public CommonResponse<User> getUserByUsername(@RequestParam(name = "username", defaultValue = "") String username) throws UserException {
		CommonResponse<User> us = new CommonResponse<>();
		User user = userService.getByUsername(username);
		if (user != null) {
			us.setCode("33");
			us.setDescription("Username is already registered");
		} else {
			us.setCode("01");
			us.setDescription("Success");
		}
		return us;
	}

}
