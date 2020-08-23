package com.bootcamp.sti.wall.dao.implement;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.sti.wall.dao.DummyDao;
import com.bootcamp.sti.wall.dao.WalletTypeDao;
import com.bootcamp.sti.wall.dto.WalletTypeDto;
import com.bootcamp.sti.wall.model.WalletType;
import com.bootcamp.sti.wall.repositories.WalletTypeRepository;

public class WalletTypeDaoImpl implements WalletTypeDao{
	@PersistenceContext
	private EntityManager em;
	
	private DummyDao dd;
	
	@Autowired
	private WalletTypeRepository wr;
	@Override
	public List<WalletType> getListWalletType() {
		Query query = em.createQuery("From WalletType");
		return query.getResultList();
	}
	@Transactional
	@Override
	public WalletType createWalletType(WalletTypeDto walletType) {
		WalletType waltyp = setData(walletType);
		 
		return em.merge(waltyp);
	}

	@Override
	public WalletType getWalletByDescription(String name) {
		return  wr.findByDescription(name);
		
	}
	@Override
	public WalletType setData(WalletTypeDto dto) {
		WalletType walt = new WalletType();
		walt.setOpenDate(dto.getOpenDate());
		walt.setDescription(dto.getDescription());
		walt.setOpenDate(dto.getOpenDate());
		return walt;

	}
}
