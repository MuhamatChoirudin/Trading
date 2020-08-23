package com.bootcamp.sti.wall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="TransactionType")
@Table(name="tb_transaction_type")
public class TransactionType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_transaction_type")	
	private String idTransactionType;
	@Column(name="description")
	private String description;
	public String getIdTransactionType() {
		return idTransactionType;
	}
	public void setIdTransactionType(String idTransactionType) {
		this.idTransactionType = idTransactionType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
