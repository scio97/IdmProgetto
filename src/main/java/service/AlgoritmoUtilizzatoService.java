package service;

import dao.AlgoritmoUtilizzatoDAO;
import entity.AlgoritmoUtilizzato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AlgoritmoUtilizzatoService{



	@Autowired
	private AlgoritmoUtilizzatoDAO algoritmoUtilizzatoDAO;

	public List<AlgoritmoUtilizzato> getListaAlgoritmoUtilizzato() {
		try {
			List<AlgoritmoUtilizzato> s=algoritmoUtilizzatoDAO.retrieve();
			return s;
		} catch (Exception e) {
			throw e;
		}
	}

	public List<String> getListaString() {
		try {
			List<AlgoritmoUtilizzato> s=algoritmoUtilizzatoDAO.retrieve();
			List<String> temp = new ArrayList<>();
			for(int i=0; i<s.size(); i++){
				temp.add(s.get(i).getAlgoritmo());
			}
			return temp;
		} catch (Exception e) {
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
			algoritmoUtilizzatoDAO.delete(algoritmoUtilizzatoDAO.findById(id));
		} catch (Exception e) {
			throw e;
		}
	}

	public void insertRecord(AlgoritmoUtilizzato elemento){
		try {
			System.out.println("Service " + elemento);
			algoritmoUtilizzatoDAO.create(elemento);
		} catch (Exception e) {
			throw e;
		}
	}

	public AlgoritmoUtilizzato findById(int id){
		try {
			AlgoritmoUtilizzato temp= algoritmoUtilizzatoDAO.findById(id);
			return temp;
		} catch (Exception e) {
			throw e;
		}
	}
}
