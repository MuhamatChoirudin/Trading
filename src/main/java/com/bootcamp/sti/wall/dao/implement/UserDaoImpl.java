package com.bootcamp.sti.wall.dao.implement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.bootcamp.sti.wall.dao.UserDao;
import com.bootcamp.sti.wall.dto.UserDto;
import com.bootcamp.sti.wall.exception.EntityNotFoundException;
import com.bootcamp.sti.wall.model.User;
import com.bootcamp.sti.wall.repositories.UserRepository;

public class UserDaoImpl implements UserDao {
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private UserRepository ur;

	@Override
	public User getByUsernamePassword(String username, String password) throws EntityNotFoundException {
		User user = ur.findByUsernameAndPassword(username, password);
		if (user == null) {
			throw new EntityNotFoundException("66", "Entity Not Found");
		}

		return user;

	}

	@Override
	@Transactional
	public User createUser(UserDto user) {
		String id = "";
		Query query = em.createQuery("FROM User order by id_user desc");
		query.setMaxResults(1);
		if (query.getResultList().isEmpty()) {
			id = "30001";
		} else {
			User us = (User) query.getSingleResult();
			String tid = us.getIdUser();
			int idd = Integer.parseInt(tid) + 1;
			id = String.valueOf(idd);
		}
		User us = setData(user);
		us.setIdUser(id);
		return em.merge(us);
		
	}

	@Override
	public User getByUsername(String username) {

		return ur.findByUsername(username);
	}
	
	public User setData(UserDto dto) {
		User user = new User();
		user.setIdRoleType(dto.getIdRoleType());
		user.setPassword(dto.getPassword());
		user.setUsername(dto.getUsername());
		user.setRegisterDate(dto.getRegisterDate());
		
		return user;
	}

}
