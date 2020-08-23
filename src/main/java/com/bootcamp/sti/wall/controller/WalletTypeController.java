package com.bootcamp.sti.wall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.sti.wall.dao.WalletTypeDao;
import com.bootcamp.sti.wall.dto.CommonResponse;
import com.bootcamp.sti.wall.dto.WalletTypeDto;
import com.bootcamp.sti.wall.exception.EntityNotFoundException;
import com.bootcamp.sti.wall.exception.RegisteredException;
import com.bootcamp.sti.wall.model.WalletType;
@CrossOrigin
@RestController
public class WalletTypeController {
	public static final String URL_WALLET_TYPE = "walletType";
	public static final String URL_LISTS = "walletTypes";
	@Autowired
	private WalletTypeDao walletTypeDao;
	
	@GetMapping(value = URL_WALLET_TYPE +"/"+URL_LISTS)
	public CommonResponse<List<WalletType>> getList() throws EntityNotFoundException {
		List<WalletType> data = walletTypeDao.getListWalletType();
		CommonResponse<List<WalletType>> resp = new CommonResponse<>();
		if (data.isEmpty()) {
			resp.setData(data);
			throw new EntityNotFoundException();
			
		} else {
			resp.setData(data);
		}
		return resp;
	}
	
	@PostMapping(value = URL_WALLET_TYPE)
	public CommonResponse<WalletType> createWalletType(@RequestBody WalletTypeDto wallet) throws RegisteredException {
		String wall = wallet.getDescription();
		CommonResponse<WalletType> resp = new CommonResponse<>();
			if(walletTypeDao.getWalletByDescription(wall) != null) {
				throw new RegisteredException();
			}else {
				resp.setCode("01");
				resp.setDescription("Success");
				resp.setData(walletTypeDao.createWalletType(wallet));
			}
		return resp;
	}
}
