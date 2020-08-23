package com.bootcamp.sti.wall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.sti.wall.dao.BankDao;
import com.bootcamp.sti.wall.dto.BankDto;
import com.bootcamp.sti.wall.dto.CommonResponse;
import com.bootcamp.sti.wall.exception.EntityNotFoundException;
import com.bootcamp.sti.wall.exception.RegisteredException;
import com.bootcamp.sti.wall.model.Bank;

@CrossOrigin
@RestController

public class BankController {
	public static final String URL_BANK = "bank";
	public static final String URL_LISTS = "banks";
	
	@Autowired
	private BankDao bankDao;
	
	@PostMapping(value = URL_BANK)
	public CommonResponse<Bank> createBank(@RequestBody BankDto bank) throws RegisteredException {
		
		String cas = bank.getIdBank();
		CommonResponse<Bank> resp = new CommonResponse<>();

			if(bankDao.getByIdBank(cas)!= null) {
				throw new RegisteredException();
			}else {
				resp.setCode("01");
				resp.setDescription("Success");
				resp.setData(bankDao.createBank(bank));
			}
		return resp;
	}
	
	@GetMapping(value = URL_LISTS)
	public CommonResponse<List<Bank>> getList() throws EntityNotFoundException {
		List<Bank> data = bankDao.getListBank();
		CommonResponse<List<Bank>> resp = new CommonResponse<>();
		if (data.isEmpty()) {
			throw new EntityNotFoundException();
		} else {
			resp.setData(data);
		}
		return resp;
	}
}
