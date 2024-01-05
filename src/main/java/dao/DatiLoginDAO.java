package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.DatiLogin;
import org.springframework.stereotype.Repository;

@Repository
public class DatiLoginDAO implements DatiLoginDAOInterface {

	@PersistenceContext
	private EntityManager manager;

	public DatiLoginDAO(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void create(DatiLogin ref) {
		manager.persist(ref);

	}

	@Override
	public void update(DatiLogin ref) {
		manager.persist(ref);

	}

	@Override
	public void delete(DatiLogin ref) {
		manager.remove(ref);

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
