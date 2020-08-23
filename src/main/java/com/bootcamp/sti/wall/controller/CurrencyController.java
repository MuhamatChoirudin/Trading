package com.bootcamp.sti.wall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.sti.wall.dao.CurrencyDao;
import com.bootcamp.sti.wall.dao.TransactionForexDao;
import com.bootcamp.sti.wall.dto.CommonResponse;
import com.bootcamp.sti.wall.dto.CurrencyDto;
import com.bootcamp.sti.wall.exception.BalanceNotEnoughException;
import com.bootcamp.sti.wall.model.Currency;
import com.bootcamp.sti.wall.model.TransactionForex;

@CrossOrigin
@RestController
public class CurrencyController {
	public static final String URL_CURRENCY = "currency";
	public static final String URL_LISTS = "currencies";

	
	@Autowired
	private CurrencyDao currencyDao;
	
	@Autowired
	private TransactionForexDao transForexDao;
	
	@GetMapping(value=URL_LISTS)
	public CommonResponse<List<Currency>> getList(@RequestParam(name="description", defaultValue="")String description){
		CommonResponse<List<Currency>> us = new CommonResponse<>();
		us.setData(currencyDao.getListCurrency(description));
		return us;
	}
	
	@Transactional
	@PostMapping(value = URL_CURRENCY)
	public CommonResponse<Currency> createCurrency(@RequestBody CurrencyDto currency) throws BalanceNotEnoughException {
		updatePotensialPL(currency);
		double buy = currency.getBuy();
		double sell = currency.getSell();
		CommonResponse<Currency> resp = new CommonResponse<>();
			if(buy <=0 || sell <= 0) {
				throw new BalanceNotEnoughException();
			}else {
				resp.setCode("01");
				resp.setDescription("Success");
				resp.setData(currencyDao.createCurrency(currency));
			}
		return resp;
	}

	private void updatePotensialPL(CurrencyDto currency) {
		List<TransactionForex> transF = transForexDao.getTransForex();
		for(TransactionForex newTrans : transF) {
			newTrans.setPotensialPoinLose(newTrans.getRate() - currency.getSell());
			transForexDao.save(newTrans);
		}
	}
}
