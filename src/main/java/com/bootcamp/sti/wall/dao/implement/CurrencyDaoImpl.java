package com.bootcamp.sti.wall.dao.implement;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.bootcamp.sti.wall.dao.CurrencyDao;
import com.bootcamp.sti.wall.dto.CurrencyDto;
import com.bootcamp.sti.wall.model.Currency;
import com.bootcamp.sti.wall.repositories.CurrencyRepository;

public class CurrencyDaoImpl implements CurrencyDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private CurrencyRepository cr;
	@Override
	public double getBuy() {
		Currency curr = getCurrency();
        return curr.getBuy();
		
	}

	@Override
	public double getSell() {
				Currency curr = getCurrency();
				return curr.getSell();
	}
	

	@Override
	public Currency createCurrency(CurrencyDto currency) {
		int id=0;
		Query query = em.createQuery("FROM Currency order by id_currency desc");
        query.setMaxResults(1);
        if(query.getResultList().isEmpty()){
            id = 70001;
        } else {
            Currency ac = (Currency) query.getSingleResult();
           id= ac.getIdCurrency()+1;
          
            
        }
        Currency curr = setData(currency);
        
       curr.setIdCurrency(id);
		
		return cr.save(curr);
	}

	@Override
	public List<Currency> getListCurrency(String description) {

		return cr.findByDescription(description);
	}

	@Override
	public Currency getCurrency() {
		Query query = em.createQuery("FROM Currency order by date desc");
        query.setMaxResults(1);
        
		return (Currency) query.getSingleResult();
	}

	@Override
	public Currency getCurrencyById(int idCurrency) {
		return em.find(Currency.class, idCurrency);
	}

	public Currency setData(CurrencyDto dto) {
		Currency currency = new Currency();
		currency.setBuy(dto.getBuy());
		currency.setSell(dto.getSell());
		currency.setCcyBase(dto.getCcyBase());
		currency.setCcyDestination(dto.getCcyDestination());
		currency.setDate(dto.getDate());
		currency.setDescription(dto.getDescription());
		return currency;
	}
}
