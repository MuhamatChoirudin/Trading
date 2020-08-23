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

import com.bootcamp.sti.wall.dao.TransactionForexDao;
import com.bootcamp.sti.wall.dto.CommonResponse;
import com.bootcamp.sti.wall.dto.TransactionForexDto;
import com.bootcamp.sti.wall.exception.BalanceNotEnoughException;
import com.bootcamp.sti.wall.exception.EntityNotFoundException;
import com.bootcamp.sti.wall.model.TransactionForex;

@CrossOrigin
@RestController
public class TransactionForexController {
	public static final String URL_TRANSACTION_FOREX = "transactionf";
	public static final String URL_TRADER = "trader";
	public static final String URL_BUY = "buy";
	public static final String URL_SELL = "sell";
	public static final String URL_TOTAL_AMOUNT = "amount";

	@Autowired
	private TransactionForexDao transactionForexService;

	@GetMapping(value = URL_TRANSACTION_FOREX)
	public CommonResponse<List<TransactionForex>> getList(@RequestParam(name = "idtrader", defaultValue = "") String idTrader) {
		CommonResponse<List<TransactionForex>> us = new CommonResponse<>();
		us.setData(transactionForexService.getByIdTraderAscDate(idTrader));
		return us;
	}
	
	@GetMapping(value = URL_TOTAL_AMOUNT)
	public CommonResponse<Double> getAmount(@RequestParam(name = "idtrader", defaultValue = "") String idTrader)  throws EntityNotFoundException{
		CommonResponse<Double> resp = new CommonResponse<>();
		if(transactionForexService.getByIdTrader(idTrader) == null) {
			throw new EntityNotFoundException();
		} else {
			double data = transactionForexService.getAmountForex(idTrader);
				resp.setData(data);
		}
		return resp;
	}	

	@Transactional
	@PostMapping(value = URL_TRANSACTION_FOREX + "/" + URL_TRADER + "/" + URL_BUY)
	public CommonResponse<TransactionForex> buy(@RequestBody TransactionForexDto transactionForex) throws BalanceNotEnoughException {
		CommonResponse<TransactionForex> us = new CommonResponse<>();
		us.setData(transactionForexService.buy(transactionForex));
		return us;
	}

	@PostMapping(value = URL_TRANSACTION_FOREX + "/" + URL_TRADER + "/" + URL_SELL)
	@Transactional
	public CommonResponse<TransactionForex> sell(@RequestBody TransactionForexDto transactionForex) throws BalanceNotEnoughException {
		CommonResponse<TransactionForex> us = new CommonResponse<>();
		us.setData(transactionForexService.newSell(transactionForex));
		return us;
	}
}