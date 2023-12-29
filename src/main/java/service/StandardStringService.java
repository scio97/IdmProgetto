package service;

import dao.StandardStringDAO;
import entity.StandardString;

import javax.persistence.EntityManager;
import java.util.List;

public class StandardStringService {

    private EntityManager manager;

    private StandardStringDAO standardStringDAO;

    public StandardStringService(EntityManager manager, StandardStringDAO standardStringDAO) {
        this.manager = manager;
        this.standardStringDAO = standardStringDAO;
    }

    public List<StandardString> getListaStrings() {
        try {
            manager.getTransaction().begin();
            List<StandardString> s=standardStringDAO.retrieve();
            manager.getTransaction().commit();
            return s;
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        }
    }

    public void updateStringa(int id,String stringa){
        try {
            manager.getTransaction().begin();
            StandardString temp = standardStringDAO.findById(id);
            temp.setValue(stringa);
            standardStringDAO.update(temp);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        }
    }

    public void deleteStringa(int id){
        try {
            manager.getTransaction().begin();
            standardStringDAO.delete(standardStringDAO.findById(id));
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        }
    }

    public void insertStringa(StandardString elemento){
        try {
            manager.getTransaction().begin();
            standardStringDAO.create(elemento);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        }
    }

    public StandardString findById(int id){
        try {
            manager.getTransaction().begin();
            StandardString temp= standardStringDAO.findById(id);
            manager.getTransaction().commit();
            return temp;
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        }
    }
}
