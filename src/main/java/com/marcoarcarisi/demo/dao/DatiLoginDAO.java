package com.marcoarcarisi.demo.dao;

import com.marcoarcarisi.demo.entity.DatiLogin;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DatiLoginDAO implements DatiLoginDAOInterface {

	@PersistenceContext
	EntityManager manager;

	public DatiLoginDAO(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void create(DatiLogin ref) {
		manager.getTransaction().begin();
		manager.persist(ref);
		manager.getTransaction().commit();
	}

	@Override
	public void update(DatiLogin ref) {
		manager.getTransaction().begin();
		manager.persist(ref);
		manager.getTransaction().commit();

	}

	@Override
	public void delete(DatiLogin ref) {
		manager.getTransaction().begin();
		manager.remove(ref);
		manager.getTransaction().commit();
	}

	@Override
	public List<DatiLogin> retrieve() {
		return manager.createQuery("select x from datiLogin x", DatiLogin.class).getResultList();
	}

	@Override
	public DatiLogin findByUserName(String userName) {
		return manager.find(DatiLogin.class, userName);
	}
}
