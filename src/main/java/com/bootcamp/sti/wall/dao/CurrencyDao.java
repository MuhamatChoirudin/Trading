package com.bootcamp.sti.wall.dao;

import java.util.List;

import com.bootcamp.sti.wall.dto.CurrencyDto;
import com.bootcamp.sti.wall.model.Currency;

public interface CurrencyDao {
	List<Currency> getListCurrency(String description);

	double getBuy();

	double getSell();

	Currency createCurrency(CurrencyDto currency);

	Currency getCurrency();

	Currency getCurrencyById(int idCurrency);
}
