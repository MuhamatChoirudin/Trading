package com.bootcamp.sti.wall.dao.implement;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import com.bootcamp.sti.wall.dao.AccountDao;
import com.bootcamp.sti.wall.dto.AccountDto;
import com.bootcamp.sti.wall.model.Account;
import com.bootcamp.sti.wall.model.StatusType;
import com.bootcamp.sti.wall.repositories.AccountRepository;

public class AccountDaoImpl implements AccountDao{
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private AccountRepository ar;
	
	@Override
	public List<Account> getListAccount() {
		Query query = em.createQuery("From Account");
		return query.getResultList();
	}
	
	@Override
	public List<Account> getListAccount(String cif) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Account> query = builder.createQuery(Account.class);
		Root<Account> root = query.from(Account.class);
		
		query.select(root).where(builder.equal(root.get("customer").get("cif"), cif));
		
		Query q = em.createQuery(query);
				
		return q.getResultList();
	}

	@Override
	public Account createAccount(AccountDto account) {	
		String id="";
		Query query = em.createQuery("FROM Account order by account_number desc");
        query.setMaxResults(1);
        if(query.getResultList().isEmpty()){
            id = "40001";
        } else {
            Account ac = (Account) query.getSingleResult();
           String tac= ac.getAccountNumber();
           int idd = Integer.parseInt(tac)+1;
            id=String.valueOf(idd);
        }
        Account ac = setData(account);
        
       ac.setAccountNumber(id);
       ac.setBalance(0);		 
		return ar.save(ac);
		
	}

	@Override
	public Account getByAccountNumber(String accountNumber)  {
		return em.find(Account.class, accountNumber);
	}

	@Override
	public Account updateAccount(AccountDto account) {
		StatusType sta = new StatusType();
		Account newAcc = setData(account);
		sta.setIdStatusType(1);
		newAcc.setIdStatusType(sta);
		return em.merge(newAcc);	
		}

	@Override
	public Account getByCashtag(String cashtag) {
		
		return ar.findByCashtag(cashtag);
	}

	@Override
	public double getBalance(String accountNumber) {
		Account account = em.find(Account.class, accountNumber);
		return account.getBalance();
		
	}

	@Override
	public Account updateBalance(String accountNumber, double result) {
		Account account = em.find(Account.class, accountNumber);
		account.setBalance(result);
		return em.merge(account);
	}

	@Override
	public void creditAccount(String accountNumber, double amount) {
		double balance = getBalance(accountNumber);
		updateBalance(accountNumber, balance+amount);
	}

	@Override
	public void debitAccount(String accountNumber, double amount) {
		double balance = getBalance(accountNumber);
		updateBalance(accountNumber, balance-amount);
		
	}
	
	public Account setData (AccountDto dto) {
		 Account account = new Account();
		 account.setAccountNumber(dto.getAccountNumber());
		account.setBalance(dto.getBalance());
		account.setOpenDate(dto.getOpenDate());
		account.setCashtag(dto.getCashtag());
		account.setCustomer(dto.getCustomer());
		account.setIdStatusType(dto.getIdStatusType());
		return account;
	}
	

}
