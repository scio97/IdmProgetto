package dao;

import java.util.List;
import javax.persistence.EntityManager;
import entity.DatiLogin;

public class DatiLoginDAO implements DatiLoginDAOInterface {

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
