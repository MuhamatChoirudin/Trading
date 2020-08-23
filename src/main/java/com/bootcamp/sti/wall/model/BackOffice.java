package com.bootcamp.sti.wall.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "BackOffice")
@Table(name = "tb_backoffice")
public class BackOffice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_backoffice")
	private String idBackoffice;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "address")
	private String address;

	@Column(name = "open_date")
	private Date openDate;

	@Column(name = "count_id_backoffice")
	private int countIdBackoffice;

	@ManyToOne
	@JoinColumn(name = "id_user")
	private User idUser;

	public int getCountIdBackoffice() {
		return countIdBackoffice;
	}

	public void setCountIdBackoffice(int countIdBackoffice) {
		this.countIdBackoffice = countIdBackoffice;
	}

	public String getIdBackoffice() {
		return idBackoffice;
	}

	public void setIdBackoffice(String idBackoffice) {
		this.idBackoffice = idBackoffice;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public User getIdUser() {
		return idUser;
	}

	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}

}
