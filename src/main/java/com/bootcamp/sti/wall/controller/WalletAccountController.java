package com.bootcamp.sti.wall.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.sti.wall.dao.WalletAccountDao;
import com.bootcamp.sti.wall.dto.CommonResponse;
import com.bootcamp.sti.wall.dto.WalletAccountDto;
import com.bootcamp.sti.wall.exception.EntityNotFoundException;
import com.bootcamp.sti.wall.exception.RegisteredException;
import com.bootcamp.sti.wall.model.WalletAccount;

@CrossOrigin
@RestController
public class WalletAccountController {
	public static final String URL_LISTS = "walletaccounts/{cif}";
	public static final String URL_ACCOUNT = "account";
	public static final String URL_WALLET_ACCOUNT = "walletaccount";
	public static final String URL_WALLET_ACCOUNT_BY_ACCOUNT = "walletaccount/{id}";

	public static final String URL_WALLET_ACCOUNT_BY_CIF = "walletaccountcif/{cif}";
	@Autowired
	private WalletAccountDao walletAccountDao;
	
	@Transactional
	@PostMapping(value = URL_ACCOUNT+"/"+URL_WALLET_ACCOUNT)
	public CommonResponse<WalletAccount> createAccount(@RequestBody WalletAccountDto wallet) throws RegisteredException{
		
		String cas = wallet.getAccount().getAccountNumber();
		WalletAccount walldata = walletAccountDao.getWalletAccountByAccountNumber(cas);
		CommonResponse<WalletAccount> resp = new CommonResponse<>();

			if(walldata != null) {
				throw new RegisteredException();
			}else {
				resp.setCode("01");
				resp.setDescription("Success");
				resp.setData(walletAccountDao.registerWalletAccount(wallet));
			}
			
		
		return resp;
	}
	
	@Transactional
	@PutMapping(value = URL_ACCOUNT+"/"+URL_WALLET_ACCOUNT)
	public CommonResponse<WalletAccount> updateAccount(@RequestBody WalletAccountDto wallet) throws EntityNotFoundException{
		String tempAccount = wallet.getAccount().getAccountNumber();
		CommonResponse<WalletAccount> resp = new CommonResponse<>();
		if(tempAccount == null) {
			throw new EntityNotFoundException();
		} else {
			
			
				resp.setData(walletAccountDao.updateWalletAccount(wallet));
			
		}
		return resp;
	}
	
	@GetMapping(value = URL_ACCOUNT+"/"+URL_LISTS)
	public CommonResponse<List<WalletAccount>> getList(@PathVariable(name = "cif") String cif) throws EntityNotFoundException {
		List<WalletAccount> cifData = walletAccountDao.getListWalletAccount(cif);
		CommonResponse<List<WalletAccount>> resp = new CommonResponse<>();
		if (cifData == null) {
			throw new EntityNotFoundException();
		} else {
			resp.setData(cifData);
		}
		return resp;
	}
	
	@GetMapping(value = URL_ACCOUNT+"/"+URL_WALLET_ACCOUNT_BY_ACCOUNT)
	public CommonResponse<WalletAccount> getByAccountId(@PathVariable(name = "id") String id) throws EntityNotFoundException {
		WalletAccount account = walletAccountDao.getWalletAccountByAccountNumber(id);
		CommonResponse<WalletAccount> resp = new CommonResponse<>();
		if (account == null) {
			throw new EntityNotFoundException();
		} else {
			resp.setData(account);
		}
		return resp;
	}
	
}
