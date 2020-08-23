package com.bootcamp.sti.wall.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.sti.wall.dao.AccountDao;
import com.bootcamp.sti.wall.dao.BankDao;
import com.bootcamp.sti.wall.dao.DummyDao;
import com.bootcamp.sti.wall.dao.TraderDao;
import com.bootcamp.sti.wall.dao.TransactionDao;
import com.bootcamp.sti.wall.dto.CommonResponse;
import com.bootcamp.sti.wall.dto.TransactionDto;
import com.bootcamp.sti.wall.model.Transaction;

@CrossOrigin
@RestController
public class TransactionController {
	public static final String URL_CUSTOMER = "customer";
	public static final String URL_TRANSACTION = "transaction";
	public static final String URL_REQUEST_TRANSACTION_BY_ACCOUNT_ID = "transaction/{accountNumber}";
	@Autowired
	private TransactionDao transactionDao;

	@Autowired
	private AccountDao accountDao;

	@Autowired
	private DummyDao dummyDao;
	@Autowired
	private TraderDao traderDao;
	@Autowired
	private BankDao bankDao;
	@Transactional
	@PostMapping(value = URL_CUSTOMER + "/" + URL_TRANSACTION)
	public CommonResponse<Transaction> transcation(@RequestBody TransactionDto transactiondto) {

		CommonResponse<Transaction> resp = new CommonResponse<>();
		String accountNumberCredit = transactiondto.getAccountCredit();
		String accountNumberDebit = transactiondto.getAccountDebit();
		double amount = transactiondto.getAmount();
		int codeTransaction = Integer.parseInt(transactiondto.getTransactionType().getIdTransactionType());
		double newAmount = 0;
		if (accountNumberDebit.charAt(0) == '2') {
			newAmount = traderDao.getBalance(accountNumberDebit);
		} else if (accountNumberDebit.charAt(0) == '4') {
			newAmount = accountDao.getBalance(accountNumberDebit);
		} else {
			newAmount = bankDao.getBalance(accountNumberDebit);
		}

		if (accountNumberCredit.isEmpty()) {
			resp.setCode("66");
			resp.setDescription("Wallet not found");
		} else if (amount <= 0 || amount >= newAmount) {
			resp.setCode("22");
			resp.setDescription("Balance not enough");
		} else if (accountNumberDebit.equals(accountNumberCredit)) {
			resp.setCode("44");
			resp.setDescription("not permitted because of your own account");
		} else {
			switch (codeTransaction) {
			case 1:
				dummyDao.creditDummy(accountNumberCredit, amount);
				accountDao.debitAccount(accountNumberDebit, amount);
				resp.setData(transactionDao.createTransaction(transactiondto));
				break;
			case 2:
				accountDao.creditAccount(accountNumberCredit, amount);
				accountDao.debitAccount(accountNumberDebit, amount);
				resp.setData(transactionDao.createTransaction(transactiondto));
				break;
			case 3:
				traderDao.creditTrader(accountNumberCredit, amount);
				accountDao.debitAccount(accountNumberDebit, amount);
				resp.setData(transactionDao.createTransaction(transactiondto));
				break;
			case 4:
				traderDao.debitTrader(accountNumberDebit, amount);
				accountDao.creditAccount(accountNumberCredit, amount);
				resp.setData(transactionDao.createTransaction(transactiondto));
				break;
			case 5:
				bankDao.debitBank(accountNumberDebit, amount);
				accountDao.creditAccount(accountNumberCredit, amount);
				resp.setData(transactionDao.createTransaction(transactiondto));
				break;
			default:
				resp.setCode("66");
				resp.setDescription("Transaction type not enough");
			}
		}

		return resp;
	}

	@Transactional
	@GetMapping(value = URL_CUSTOMER + "/" + URL_REQUEST_TRANSACTION_BY_ACCOUNT_ID)
	public CommonResponse<List<Transaction>> getTransactionByAccountNumber(
			@PathVariable(name = "accountNumber") String accountNumber) {
		String tempAccNumCre = accountNumber;
		String tempAccNumDeb = accountNumber;
		CommonResponse<List<Transaction>> resp = new CommonResponse<>();
		resp.setData(transactionDao.getTransactionsByAccountNumber(tempAccNumCre, tempAccNumDeb));
		return resp;

	}

}
