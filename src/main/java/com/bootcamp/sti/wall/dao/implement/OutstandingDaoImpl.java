package com.bootcamp.sti.wall.dao.implement;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.bootcamp.sti.wall.dao.OutstandingDao;
import com.bootcamp.sti.wall.dao.TraderDao;
import com.bootcamp.sti.wall.dao.TransactionForexDao;
import com.bootcamp.sti.wall.dto.OutstandingDto;
import com.bootcamp.sti.wall.model.Outstanding;
import com.bootcamp.sti.wall.model.Trader;
import com.bootcamp.sti.wall.model.TransactionForex;
import com.bootcamp.sti.wall.repositories.OutstandingRepository;

public class OutstandingDaoImpl implements OutstandingDao {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private OutstandingRepository or;

	@Autowired
	private TransactionForexDao transForexService;
	
	@Autowired
	private TraderDao traderService;
	
	@Override
	public Outstanding outstanding(OutstandingDto outstanding) throws ParseException {
		Outstanding out = setData(outstanding);
		Query query = em.createQuery("FROM TransactionForex order by date desc");
        query.setMaxResults(1);
        TransactionForex transF = (TransactionForex) query.getSingleResult();
		List<TransactionForex> listTransForex = transForexService.getByDate(transF.getDate());
		List<Trader> listTraders = traderService.getlistTrader();
		Double newOut = 0.0;
		
		for(Trader tradersList : listTraders) {
			for(TransactionForex outTransF : listTransForex) {
				if(tradersList.getIdTrader().equals(outTransF.getIdTrader().getIdTrader()) && outTransF.getBuySell().equals("Sell")) {
					newOut = newOut + outTransF.getPointLose();
				}
			}
			if(newOut != 0.0) {
				saveOutstanding(newOut, tradersList, transF.getDate());
			}
		}
		return out;
	}
	
	public void saveOutstanding(Double out, Trader trader, Date date) {
		Outstanding outSt = new Outstanding();
		outSt.setDate(date);
		outSt.setIdTrader(trader);
		outSt.setOutstandingData(out);
		or.save(outSt);
	}
	@Override
	public Outstanding setData(OutstandingDto dto) {
		Outstanding out = new Outstanding();
		out.setIdTrader(dto.getIdTrader());
		out.setDate(dto.getDate());
		out.setOutstandingData(dto.getOutstandingData());
		out.setIdOutstanding(dto.getIdOutstanding());
		return out;
	}

	@Override
	public List<Outstanding> getList(String idTrader) {
		return or.findByIdTraderIdTrader(idTrader);
	}

	@Override
	public List<Outstanding> getListAll() {
		Query query = em.createQuery("From Outstanding");
		return query.getResultList();
	}
}
