package com.bootcamp.sti.wall.dao.implement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.bootcamp.sti.wall.dao.BackOfficeDao;
import com.bootcamp.sti.wall.model.BackOffice;
import com.bootcamp.sti.wall.repositories.BackOfficeRepository;

public class BackOfficeDaoImpl implements BackOfficeDao {
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private BackOfficeRepository br;

	@Override
	public BackOffice getByIdUser(String idUser) {
		
		return br.findByIdUserIdUser(idUser);
	}
}
