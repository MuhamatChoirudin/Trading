package com.bootcamp.sti.wall.dto;

import java.util.Date;

import com.bootcamp.sti.wall.model.RoleType;

public class UserDto {
	private String idUser;
	private String username;
	private  String password;
	private  Date registerDate;
	private RoleType idRoleType;
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public RoleType getIdRoleType() {
		return idRoleType;
	}
	public void setIdRoleType(RoleType idRoleType) {
		this.idRoleType = idRoleType;
	}
	
	
	

	
}
