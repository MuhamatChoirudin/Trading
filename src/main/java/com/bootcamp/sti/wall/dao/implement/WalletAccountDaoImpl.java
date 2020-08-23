package com.bootcamp.sti.wall.dao.implement;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;

import com.bootcamp.sti.wall.dao.WalletAccountDao;
import com.bootcamp.sti.wall.dto.WalletAccountDto;
import com.bootcamp.sti.wall.model.WalletAccount;
import com.bootcamp.sti.wall.repositories.WalletAccountRepository;


public class WalletAccountDaoImpl implements WalletAccountDao {
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private WalletAccountRepository war;
	@Override
	public List<WalletAccount> getListWalletAccount(String cif) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<WalletAccount> query = builder.createQuery(WalletAccount.class);
		Root<WalletAccount> root = query.from(WalletAccount.class);
		
		query.select(root).where(builder.equal(root.get("customer").get("cif"), cif));
		
		Query q = em.createQuery(query);
				
		return q.getResultList();
	}

	@Override
	public WalletAccount registerWalletAccount(WalletAccountDto wallet) {
		String id="";
		Query query = em.createQuery("FROM WalletAccount order by id_wallet desc");
        query.setMaxResults(1);
        if(query.getResultList().isEmpty()){
            id = "50001";
        } else {
            WalletAccount wal = (WalletAccount) query.getSingleResult();
           String tac= wal.getIdWallet();
           int idd = Integer.parseInt(tac)+1;
            id=String.valueOf(idd);
        }
        WalletAccount wallcon =setData(wallet);
       wallcon.setIdWallet(id);
		return em.merge(wallcon);
	}


	@Override
	public WalletAccount updateWalletAccount(WalletAccountDto wallet) {
		WalletAccount wallletAccount = setData(wallet);
		return em.merge(wallletAccount);
	}

	@Override
	public WalletAccount getWalletAccountByAccountNumber(String accountNumber) {

	return war.findByAccountAccountNumber(accountNumber);

	}

	public WalletAccount setData(WalletAccountDto dto) {
		WalletAccount walco = new WalletAccount();
		walco.setIdWallet(dto.getIdWallet());
		walco.setAccount(dto.getAccount());
		walco.setCustomer(dto.getCustomer());
		walco.setWalletType(dto.getWalletType());
		walco.setOpenDate(dto.getOpenDate());
		return walco;
		
	}

}
