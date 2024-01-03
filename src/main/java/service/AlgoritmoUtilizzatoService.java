package service;

import dao.AlgoritmoUtilizzatoDAO;
import entity.AlgoritmoUtilizzato;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class AlgoritmoUtilizzatoService {

	private EntityManager manager;

	private AlgoritmoUtilizzatoDAO algoritmoUtilizzatoDAO;

	public AlgoritmoUtilizzatoService(EntityManager manager, AlgoritmoUtilizzatoDAO algoritmoUtilizzatoDAO) {
		this.manager = manager;
		this.algoritmoUtilizzatoDAO = algoritmoUtilizzatoDAO;
	}

	public List<AlgoritmoUtilizzato> getListaAlgoritmoUtilizzato() {
		try {
			manager.getTransaction().begin();
			List<AlgoritmoUtilizzato> s=algoritmoUtilizzatoDAO.retrieve();
			manager.getTransaction().commit();
			return s;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}

	public List<String> getListaAlgoritmo() {
		try {
			manager.getTransaction().begin();
			List<AlgoritmoUtilizzato> s=algoritmoUtilizzatoDAO.retrieve();
			List<String> temp = new ArrayList<>();
			for(int i=0; i<s.size(); i++){
				temp.add(s.get(i).getAlgoritmo());
			}
			manager.getTransaction().commit();
			return temp;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}

	/*public void updateStringa(int id,String stringa){
        try {
            manager.getTransaction().begin();
            AlgoritmoUtilizzato temp = algoritmoUtilizzatoDAO.findById(id);
            temp.setValue(stringa);
            algoritmoUtilizzatoDAO.update(temp);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        }
    }*/

	public void deleteRecord(int id){
		try {
			manager.getTransaction().begin();
			algoritmoUtilizzatoDAO.delete(algoritmoUtilizzatoDAO.findById(id));
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}

	public void insertRecord(AlgoritmoUtilizzato elemento){
		try {
			manager.getTransaction().begin();
			algoritmoUtilizzatoDAO.create(elemento);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}

	public AlgoritmoUtilizzato findById(int id){
		try {
			manager.getTransaction().begin();
			AlgoritmoUtilizzato temp= algoritmoUtilizzatoDAO.findById(id);
			manager.getTransaction().commit();
			return temp;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
}
