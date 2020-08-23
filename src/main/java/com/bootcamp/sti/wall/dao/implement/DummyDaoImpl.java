package com.bootcamp.sti.wall.dao.implement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.bootcamp.sti.wall.dao.DummyDao;
import com.bootcamp.sti.wall.model.Dummy;
import com.bootcamp.sti.wall.repositories.DummyRepository;

public class DummyDaoImpl implements DummyDao{
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private DummyRepository dr;
	@Override
	public Dummy createDummy(Dummy dummy) {
		return em.merge(dummy);
	}

	@Override
	public double getBalance(String dummy) {
		Dummy data = dr.findByName(dummy);
		return data.getBalance();
	}

	@Override
	public Dummy updateBalance(String dummy, double result) {
		Dummy data = dr.findByName(dummy);
		data.setBalance(result);
		return em.merge(data);
	}

	@Override
	public void creditDummy(String dummy, double amount) {
		double balance = getBalance(dummy);
		double hasil = balance+amount;
		updateBalance(dummy, hasil);
	}

	@Override
	public void debitDummy(String dummy, double amount) {
		double balance = getBalance(dummy);
		double hasil = balance-amount;
		updateBalance(dummy, hasil);
	}

	
}
