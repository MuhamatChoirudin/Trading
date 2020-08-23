package com.bootcamp.sti.wall.dao.implement;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.bootcamp.sti.wall.dao.BankDao;
import com.bootcamp.sti.wall.dto.BankDto;
import com.bootcamp.sti.wall.model.Bank;

public class BankDaoImpl implements BankDao{
	@PersistenceContext
	private EntityManager em;
	@Override
	public List<Bank> getListBank() {
		Query query = em.createQuery("From Bank");
		return query.getResultList();
	}

	@Override
	public Bank createBank(BankDto bank) {
		
		String id="";
		Query query = em.createQuery("FROM Bank order by id_bank desc");
        query.setMaxResults(1);
        if(query.getResultList().isEmpty()){
            id = "7001";
        } else {
            Bank data = (Bank) query.getSingleResult();
           String tac= data.getIdBank();
           int idd = Integer.parseInt(tac)+1;
            id=String.valueOf(idd);
        }
		Bank bankData = setData(bank);
		bankData.setIdBank(id);
		return em.merge(bankData);
	}

	@Override
	public double getBalance(String idBank) {
		Bank bank = em.find(Bank.class, idBank);
		return bank.getBalance();
		
	}

	@Override
	public Bank getByIdBank(String idBank) {
		return  em.find(Bank.class, idBank);
	}
	
	@Override
	public Bank updateBalance(String idBank, double result) {
		Bank bank = em.find(Bank.class, idBank);
		bank.setBalance(result);
		
		return em.merge(bank);
	}

	@Override
	public void creditBank(String idBank, double amount) {
		double balance = getBalance(idBank);
		updateBalance(idBank, balance+amount);
	}

	@Override
	public void debitBank(String idBank, double amount) {
		double balance = getBalance(idBank);
		updateBalance(idBank, balance-amount);
	}
	@Override
	public Bank setData(BankDto dto) {
		Bank bank = new Bank();
		bank.setName(dto.getName());
		bank.setBalance(dto.getBalance());
		return bank;
	}
}
