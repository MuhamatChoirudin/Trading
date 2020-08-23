package com.bootcamp.sti.wall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.bootcamp.sti.wall.dao.AccountDao;
import com.bootcamp.sti.wall.dao.BackOfficeDao;
import com.bootcamp.sti.wall.dao.BankDao;
import com.bootcamp.sti.wall.dao.CurrencyDao;
import com.bootcamp.sti.wall.dao.CustomerDao;
import com.bootcamp.sti.wall.dao.DummyDao;
import com.bootcamp.sti.wall.dao.OutstandingDao;
import com.bootcamp.sti.wall.dao.TraderDao;
import com.bootcamp.sti.wall.dao.TransactionDao;
import com.bootcamp.sti.wall.dao.TransactionForexDao;
import com.bootcamp.sti.wall.dao.UserDao;
import com.bootcamp.sti.wall.dao.WalletAccountDao;
import com.bootcamp.sti.wall.dao.WalletTypeDao;
import com.bootcamp.sti.wall.dao.implement.AccountDaoImpl;
import com.bootcamp.sti.wall.dao.implement.BackOfficeDaoImpl;
import com.bootcamp.sti.wall.dao.implement.BankDaoImpl;
import com.bootcamp.sti.wall.dao.implement.CurrencyDaoImpl;
import com.bootcamp.sti.wall.dao.implement.CustomerDaoImpl;
import com.bootcamp.sti.wall.dao.implement.DummyDaoImpl;
import com.bootcamp.sti.wall.dao.implement.OutstandingDaoImpl;
import com.bootcamp.sti.wall.dao.implement.TraderDaoImpl;
import com.bootcamp.sti.wall.dao.implement.TransactionDaoImpl;
import com.bootcamp.sti.wall.dao.implement.TransactionForexDaoImpl;
import com.bootcamp.sti.wall.dao.implement.UserDaoImpl;
import com.bootcamp.sti.wall.dao.implement.WalletAccountDaoImpl;
import com.bootcamp.sti.wall.dao.implement.WalletTypeDaoImpl;

public class BeanConfig {

	@Bean
	public TraderDao traderService() {
		return new TraderDaoImpl();
	}

	@Bean
	public TransactionForexDao transactionForexService() {
		return new TransactionForexDaoImpl();
	}

	@Bean
	public UserDao userService() {
		return new UserDaoImpl();
	}

	@Bean
	public CustomerDao customerService() {
		return new CustomerDaoImpl();
	}

	@Bean
	public BackOfficeDao backOfficeService() {
		return new BackOfficeDaoImpl();
	}

	@Bean
	public AccountDao accountService() {
		return new AccountDaoImpl();
	}

	@Bean
	public TransactionDao transactionService() {
		return new TransactionDaoImpl();
	}

	@Bean
	public WalletAccountDao walletAccountService() {
		return new WalletAccountDaoImpl();
	}


	@Bean
	public WalletTypeDao walletTypeService() {
		return new WalletTypeDaoImpl();
	}

	@Bean
	public BankDao bankService() {
		return new BankDaoImpl();
	}

	@Bean
	public DummyDao dummyService() {
		return new DummyDaoImpl();
	}

	@Bean
	public CurrencyDao currencyService() {
		return new CurrencyDaoImpl();
	}
	
	@Bean
	public OutstandingDao outstandingService() {
		return new OutstandingDaoImpl();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
			}
		};
	}
}
