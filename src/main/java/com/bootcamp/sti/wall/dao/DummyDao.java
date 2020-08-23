package com.bootcamp.sti.wall.dao;

import com.bootcamp.sti.wall.model.Dummy;

public interface DummyDao {
	Dummy createDummy(Dummy dummy);
	double getBalance(String dummy);
	Dummy updateBalance(String dummy, double result);
	void creditDummy (String dummy, double amount);
	void debitDummy (String dummy, double amount);
	
}
