package com.bootcamp.sti.wall.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="Customer")
@Table(name="tb_customer")
public class Customer {
	@Id

	@Column(name = "cif")
	private String cif;
	
	@Column(name="id_card")
	private String idCard;
	
	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "birthdate")
	private Date birthDate;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "mother")
	private String mother;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "occupation")
	private String occupation;
	
	@Column(name = "salary")
	private String salary;
	
	@Column(name = "count_cif")
	private int countCif;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User idUser;
	
	@ManyToOne
	@JoinColumn(name = "id_image")
	private Image idImage;

	public int getCountCif() {
		return countCif;
	}

	public void setCountCif(int countCif) {
		this.countCif = countCif;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMother() {
		return mother;
	}

	public void setMother(String mother) {
		this.mother = mother;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public User getIdUser() {
		return idUser;
	}

	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}

	public Image getIdImage() {
		return idImage;
	}

	public void setIdImage(Image idImage) {
		this.idImage = idImage;
	}


	
	
}
