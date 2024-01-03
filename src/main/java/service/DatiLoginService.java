package service;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.DatiLoginDAO;
import entity.AlgoritmoUtilizzato;
import entity.DatiLogin;

public class DatiLoginService {

	private EntityManager manager;

	private DatiLoginDAO datiLoginDAO;

	public DatiLoginService(EntityManager manager, DatiLoginDAO datiLoginDAO) {
		this.manager = manager;
		this.datiLoginDAO = datiLoginDAO;
	}

	public void insertDato(DatiLogin dato) {
		try {
			// Verifica se l'username è già presente
			if (findByUserName(dato.getUserName()) == null) {
				manager.getTransaction().begin();
				datiLoginDAO.create(dato);
				manager.getTransaction().commit();
				System.out.println("Dato inserito con successo.");
			} else {
				System.out.println("L'username è già presente nel database.");
			}
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	
	public DatiLogin findByUserName(String userName) {
		try {
			manager.getTransaction().begin();
			DatiLogin temp= datiLoginDAO.findByUserName(userName);
			manager.getTransaction().commit();
			return temp;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	public void deleteDato(String user) {
		try {
			manager.getTransaction().begin();
			datiLoginDAO.delete(datiLoginDAO.findByUserName(user));
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}

}
