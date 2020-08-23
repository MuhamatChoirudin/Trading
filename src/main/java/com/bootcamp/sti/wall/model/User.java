package com.bootcamp.sti.wall.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="User")
@Table(name="tb_user")
public class User {

	@Id
	@Column(name = "id_user")	
	private String idUser;
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private  String password;
	
	@Column(name="register_date")
	private  Date registerDate;
	
	@ManyToOne
	@JoinColumn(name = "id_role_type")
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
