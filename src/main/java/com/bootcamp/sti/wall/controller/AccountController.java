package com.bootcamp.sti.wall.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.sti.wall.dao.AccountDao;
import com.bootcamp.sti.wall.dto.AccountDto;
import com.bootcamp.sti.wall.dto.CommonResponse;
import com.bootcamp.sti.wall.exception.EntityNotFoundException;
import com.bootcamp.sti.wall.exception.RegisteredException;
import com.bootcamp.sti.wall.model.Account;


@CrossOrigin
@RestController
public class AccountController {
	public static final String URL_CUSTOMER = "customer";
	public static final String URL_LISTS = "accounts/{cif}";
	public static final String URL_ACCOUNT = "account";
	public static final String URL_BACKOFFICE = "backoffice";
	public static final String URL_ACCOUNT_BY_ID = "account/{id}";
	public static final String URL_ACCOUNT_BY_CASHTAG = "accountname/{cashtag}";
	public static final String URL_ACCOUNTS = "accounts";
	
	@Autowired
	private AccountDao accountDao;
	@Transactional
	@PostMapping(value = URL_CUSTOMER+"/"+URL_ACCOUNT)
	public CommonResponse<Account> createAccount(@RequestBody AccountDto account) throws RegisteredException {
		String cas = account.getCashtag();
		CommonResponse<Account> resp = new CommonResponse<>();

			if(accountDao.getByCashtag(cas)!= null) {
				throw new RegisteredException();
			}else {
				resp.setCode("01");
				resp.setDescription("Success");
				resp.setData(accountDao.createAccount(account));
			}
		return resp;
	}
	
	@Transactional
	@PutMapping(value = URL_CUSTOMER+"/"+URL_ACCOUNT)
	public CommonResponse<Account> updateAccount(@RequestBody AccountDto account) throws RegisteredException, EntityNotFoundException{
		String tempAccount = account.getAccountNumber();
		String cas = account.getCashtag();
		CommonResponse<Account> resp = new CommonResponse<>();
		if(tempAccount == null) {
			throw new EntityNotFoundException();
		} else {
			if(accountDao.getByCashtag(cas)!= null) {
				throw new RegisteredException();
			}else {
				resp.setData(accountDao.updateAccount(account));
			}
		}
		return resp;
	}
	
	@Transactional
	@PutMapping(value = URL_BACKOFFICE+"/"+URL_ACCOUNT)
	public CommonResponse<Account> updateBalance(@RequestBody AccountDto account) throws EntityNotFoundException{
		String tempAccount = account.getAccountNumber();
		
		CommonResponse<Account> resp = new CommonResponse<>();
		if(tempAccount == null) {
			throw new EntityNotFoundException();
		} else {
		
				resp.setData(accountDao.updateBalance(tempAccount, account.getBalance()));
			
		}
		return resp;
	}
	
	@GetMapping(value = URL_CUSTOMER+"/"+URL_ACCOUNT_BY_ID)
	public CommonResponse<Account> getByAccountId(@PathVariable(name = "id") String id) throws EntityNotFoundException {
		Account account = accountDao.getByAccountNumber(id);
		CommonResponse<Account> resp = new CommonResponse<>();
		if (account == null) {
			throw new EntityNotFoundException();
		} else {
			resp.setData(account);
		}
		return resp;
	}
	
	@GetMapping(value = URL_CUSTOMER+"/"+URL_LISTS)
	public CommonResponse<List<Account>> getList(@PathVariable(name = "cif") String cif) throws EntityNotFoundException {
		List<Account> account = accountDao.getListAccount(cif);
		CommonResponse<List<Account>> resp = new CommonResponse<>();
		if (account.isEmpty()) {
			throw new EntityNotFoundException();
		} else {
			resp.setData(account);
		}
		return resp;
	}
	
	@GetMapping(value = URL_CUSTOMER+"/"+URL_ACCOUNT_BY_CASHTAG)
	public CommonResponse<Account> getByCashtag(@PathVariable(name = "cashtag") String cashtag) throws EntityNotFoundException {
		Account account = accountDao.getByCashtag(cashtag);
		CommonResponse<Account> resp = new CommonResponse<>();
		if (account == null) {
			throw new EntityNotFoundException();
		} else {
			resp.setData(account);
		}
		return resp;
	}
	
	
	@GetMapping(value = URL_ACCOUNTS)
	public CommonResponse<List<Account>> getList() throws EntityNotFoundException {
		List<Account> data = accountDao.getListAccount();
		CommonResponse<List<Account>> resp = new CommonResponse<>();
		if (data.isEmpty()) {
			resp.setData(data);
			throw new EntityNotFoundException();
			
		} else {
			resp.setData(data);
		}
		return resp;
	}
}
