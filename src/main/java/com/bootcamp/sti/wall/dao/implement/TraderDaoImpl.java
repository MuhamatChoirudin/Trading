package com.bootcamp.sti.wall.dao.implement;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.bootcamp.sti.wall.dao.CurrencyDao;
import com.bootcamp.sti.wall.dao.TraderDao;
import com.bootcamp.sti.wall.dto.TraderDto;
import com.bootcamp.sti.wall.exception.BalanceNotEnoughException;
import com.bootcamp.sti.wall.model.StatusType;
import com.bootcamp.sti.wall.model.Trader;
import com.bootcamp.sti.wall.repositories.TraderRepository;

public class TraderDaoImpl implements TraderDao{
	
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	TraderRepository tr;
	
	@Autowired
	private CurrencyDao currencyDao;

	@Override
	public Trader create(TraderDto trader) {
		String id="";
		Query query = em.createQuery("FROM Trader order by id_trader desc");
        query.setMaxResults(1);
        if(query.getResultList().isEmpty()){
            id = "20001";
        } else {
            Trader tra = (Trader) query.getSingleResult();
           String trad= tra.getIdTrader();
           int idd = Integer.parseInt(trad)+1;
            id=String.valueOf(idd);
        }
        Trader tra = setData(trader);
       tra.setIdTrader(id);
       tra.setBalance(0);
       StatusType status = new StatusType();
       status.setIdStatusType(1);
       tra.setIdStatusType(status);
		
		return em.merge(tra);
	}


	@Override
	public Trader update(TraderDto trader) {
		Trader tra = setData(trader); 
		return em.merge(tra);
	}

	@Override
	public Trader getByIdTrader(String idTrader) { 
		return em.find(Trader.class, idTrader);
	}

	@Override
	public double getBalance(String idTrader) {
		Trader trader = em.find(Trader.class, idTrader);
		return trader.getBalance();	
	}

	
	@Override
	public double buy( String idTrader, double amount) throws BalanceNotEnoughException {
		double balanceTrader = getBalance(idTrader);
		double sell = currencyDao.getSell();
		double beli = amount*sell;
		if (balanceTrader>beli) {
			
			double hasil = balanceTrader-beli;
			updateBalance(idTrader, hasil);
		}else {
			throw new BalanceNotEnoughException();
		}
		
		return beli;
	}

	@Override
	public void sell(String idTrader, double amount) {
		double balance = getBalance(idTrader);
		double buy = currencyDao.getBuy();
		double jual = amount*buy;
		double newBalance = balance + jual;
		updateBalance(idTrader, newBalance);
	}

	@Override
	public Trader updateBalance(String idTrader, double result) {
		Trader trader = em.find(Trader.class, idTrader);
		trader.setBalance(result);
		return em.merge(trader);
	}


	@Override
	public Trader getTraderByCif(String cif) {
		return tr.findByCustomerCif(cif);
	}

	@Override
	public void creditTrader(String idTrader, double amount) {
		double balance = getBalance(idTrader);
		updateBalance(idTrader, balance+amount);
	}

	@Override
	public void debitTrader(String idTrader, double amount) {
		double balance = getBalance(idTrader);
		updateBalance(idTrader, balance-amount);
	}
	
	public Trader setData (TraderDto dto) {
		Trader trader = new Trader();
		trader.setBalance(dto.getBalance());
		trader.setCustomer(dto.getCustomer());
		trader.setIdStatusType(dto.getIdStatusType());
		trader.setNameTrader(dto.getNameTrader());
		return trader;
	}

	@Override
	public Iterable<Trader> getAll() {
		return tr.findAll();
	}

	@Override
	public List<Trader> getlistTrader() {
		Query query = em.createQuery("From Trader");
		return query.getResultList();
	}
		
}
