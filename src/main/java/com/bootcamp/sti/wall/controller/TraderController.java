package com.bootcamp.sti.wall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.sti.wall.dao.TraderDao;
import com.bootcamp.sti.wall.dto.CommonResponse;
import com.bootcamp.sti.wall.dto.TraderDto;
import com.bootcamp.sti.wall.exception.EntityNotFoundException;
import com.bootcamp.sti.wall.exception.RegisteredException;
import com.bootcamp.sti.wall.model.Trader;

@CrossOrigin
@RestController
public class TraderController {
	public static final String URL_TRADER = "trader";
	public static final String URL_LISTS = "traders";
	@Autowired
	private TraderDao traderService;

	@Transactional
	@PostMapping(value = URL_TRADER)
	public CommonResponse<Trader> create(@RequestBody TraderDto trader) throws RegisteredException {
		CommonResponse<Trader> us = new CommonResponse<>();
		if (traderService.getTraderByCif(trader.getCustomer().getCif()) != null) {
			throw new RegisteredException();
		} else {
			us.setCode("01");
			us.setDescription("Success");
			us.setData(traderService.create(trader));
		}

		return us;
	}

	@GetMapping(value = URL_TRADER)
	public CommonResponse<Trader> getTrader(@RequestParam(name = "cif", defaultValue = "") String cif)
			throws EntityNotFoundException {
		Trader trader = traderService.getTraderByCif(cif);
		CommonResponse<Trader> us = new CommonResponse<>();
		if (trader == null) {
			throw new EntityNotFoundException();
		} else {
			us.setData(trader);
		}
		return us;
	}


	@PutMapping(value = URL_TRADER)
	public CommonResponse<Trader> update(@RequestBody TraderDto trader) {
		CommonResponse<Trader> us = new CommonResponse<>();
		us.setData(traderService.update(trader));
		return us;
	}
	
	@GetMapping(value = URL_LISTS)
	public CommonResponse<List<Trader>> getList() throws EntityNotFoundException {
		List<Trader> data = traderService.getlistTrader();
		CommonResponse<List<Trader>> resp = new CommonResponse<>();
		if (data.isEmpty()) {
			resp.setData(data);
			throw new EntityNotFoundException();
			
		} else {
			resp.setData(data);
		}
		return resp;
	}

}
