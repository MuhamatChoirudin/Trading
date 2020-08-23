package com.bootcamp.sti.wall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="RoleType")
@Table(name="tb_role_type")
public class RoleType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_role_type")	
	private int idRoleType;
	@Column(name="description")
	private String description;
	
	
	public int getIdRoleType() {
		return idRoleType;
	}
	public void setIdRoleType(int idRoleType) {
		this.idRoleType = idRoleType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
