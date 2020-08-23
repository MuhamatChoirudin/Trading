package com.bootcamp.sti.wall.dao.implement;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.bootcamp.sti.wall.dao.CurrencyDao;
import com.bootcamp.sti.wall.dao.TraderDao;
import com.bootcamp.sti.wall.dao.TransactionForexDao;
import com.bootcamp.sti.wall.dto.TransactionForexDto;
import com.bootcamp.sti.wall.exception.BalanceNotEnoughException;
import com.bootcamp.sti.wall.model.Currency;
import com.bootcamp.sti.wall.model.TransactionForex;
import com.bootcamp.sti.wall.repositories.TransactionForexRepository;

public class TransactionForexDaoImpl implements TransactionForexDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private TransactionForexRepository tfr;
	
	@Autowired
	private TraderDao traderDao;
	
	@Autowired
	private CurrencyDao currencyDao;
	
	@Override
	public TransactionForex buy(TransactionForexDto transactionForex) throws BalanceNotEnoughException {
		TransactionForex transForex = setData(transactionForex);
		String idTrader = transForex.getIdTrader().getIdTrader();
		double amount = transForex.getAmount();

		if (amount <= 0 || amount >= traderDao.getBalance(idTrader)) {
			throw new BalanceNotEnoughException();
		} else {
			traderDao.buy(idTrader, amount);
			transForex.setBuySell("Buy");
			Currency currency = currencyDao.getCurrency();
			transForex.setRate(currency.getSell());
			transForex.getCurrency().setIdCurrency(currency.getIdCurrency());
			transForex.setAmountAfterSell(amount);
		}
		return  tfr.save(transForex);
	}


	@Override
	public List<TransactionForex> getByIdTrader(String idTrader) {
		return tfr.getByIdTraderIdTrader(idTrader);
	}

	@Override
	public List<TransactionForex> getByIdTraderAscDate(String idTrader) {
		return tfr.getByIdTraderAscDate(idTrader);
	}


	@Override
	public TransactionForex setData(TransactionForexDto dto) {
		TransactionForex transForex = new TransactionForex();
		transForex.setIdTransactionForex(dto.getIdTransactionForex());
		transForex.setIdTrader(dto.getIdTrader());
		transForex.setAmount(dto.getAmount());
		transForex.setAmountAfterSell(dto.getAmountAfterSell());
		transForex.setBuySell(dto.getBuySell());
		transForex.setCurrency(dto.getCurrency());
		transForex.setDate(dto.getDate());
		transForex.setPointLose(dto.getPointLose());
		transForex.setPotensialPoinLose(dto.getPotensialPoinLose());
		transForex.setRate(dto.getRate());
		
		return transForex;
	}

	@Override
	public TransactionForex newSell(TransactionForexDto transactionForex) throws BalanceNotEnoughException {
		TransactionForex transF = setData(transactionForex);
		Boolean guard = guard(transF.getAmountAfterSell(), transF.getIdTrader().getIdTrader());
		if (!guard) {
			throw new BalanceNotEnoughException();
		}
		List<TransactionForex> listForex = getByIdTraderAscDate(transF.getIdTrader().getIdTrader());
		double counterAmount = transF.getAmountAfterSell();
		double newAAS = 0;
		for (TransactionForex forex : listForex) {
			if (forex.getAmountAfterSell() > 0 && counterAmount > 0 && forex.getBuySell().equalsIgnoreCase("Buy")) {
				for (float i = 0; i <= forex.getAmountAfterSell(); i++) {
					counterAmount = counterAmount - 1;
					newAAS = newAAS + 1;
					if (counterAmount == 0.0) {
						transF = sellMath(forex, newAAS);
						updateBalance(transF.getIdTrader().getIdTrader(), newAAS);
						saveSell(transF, newAAS);
						save(transF);
					} else if (newAAS == forex.getAmountAfterSell() && counterAmount >= 0.0) {
						transF = sellMath(forex, newAAS);
						updateBalance(transF.getIdTrader().getIdTrader(), newAAS);
						saveSell(transF, newAAS);
						save(transF);
						newAAS = 0;
						break;
					}
				}
			} 
		}
		return transF;
	}
	
	public Boolean guard(Double amount, String idTrader) {
		Boolean guard = false;
		double counterAmount = 0;
		List<TransactionForex> listForex = getByIdTraderAscDate(idTrader);
		for (TransactionForex forex : listForex) {
			if(forex.getBuySell().equalsIgnoreCase("Buy")) {
				counterAmount = counterAmount + forex.getAmountAfterSell();
			}
		}
		if (counterAmount >= amount) {
			guard = true;
		}
		return guard;
	}

	public void saveSell(TransactionForex tForex, double amount) {
		TransactionForex transForex = new TransactionForex();
		Currency ccy = currencyDao.getCurrency();
		transForex.setDate(new Date());
		transForex.setAmountAfterSell(amount);
		transForex.setBuySell("Sell");
		transForex.setCurrency(tForex.getCurrency());
		transForex.setIdTrader(tForex.getIdTrader());
		transForex.setRate(ccy.getBuy());
		double pl = amount * (tForex.getRate() - ccy.getBuy());
		transForex.setPointLose(pl);

		save(transForex);
	}
	
	public void updateBalance(String idTrader, double amount) {
		traderDao.sell(idTrader, amount);
	}
	
	public TransactionForex sellMath(TransactionForex forex, double newAAS) {
		forex.setAmountAfterSell(forex.getAmountAfterSell() - newAAS);
		return forex;
	}

	@Override
	public List<TransactionForex> getTransForex() {
		return tfr.getByBuySell("Buy");
	}


	@Override
	public double getAmountForex(String idTrader) {
		List<TransactionForex> listtrans = getByIdTrader(idTrader);
		double totalAmount = 0;
		for (TransactionForex forex : listtrans){
			if(forex.getBuySell().equalsIgnoreCase("Buy")) {
				totalAmount += forex.getAmountAfterSell();
			}
		}
		return totalAmount;
	}


	@Override
	public List<TransactionForex> getByDate(Date date) {
		return tfr.getByDate(date);
	}
	
	@Override
	public TransactionForex save(TransactionForex transForex) {
		return em.merge(transForex);
	}
}