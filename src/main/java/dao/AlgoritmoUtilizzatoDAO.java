package dao;

import entity.AlgoritmoUtilizzato;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AlgoritmoUtilizzatoDAO implements AlgoritmoUtilizzatoDAOInterface{

    @PersistenceContext
    private EntityManager manager;

    public AlgoritmoUtilizzatoDAO(EntityManager manager){
        this.manager = manager;
    }

    @Override
    public void create(AlgoritmoUtilizzato ref) {
        System.out.println("create DAO : " + ref);
        manager.persist(ref);
        System.out.println(ref.getId());
    }

    @Override
    public List<AlgoritmoUtilizzato> retrieve() {
        return manager.createQuery("select x from AlgoritmoUtilizzato x", AlgoritmoUtilizzato.class).getResultList();
    }

    @Override
    public void update(AlgoritmoUtilizzato ref) {
        manager.persist(ref);
    }

    @Override
    public void delete(AlgoritmoUtilizzato ref) {
        manager.remove(ref);
    }

    @Override
    public AlgoritmoUtilizzato findById(int id){
        return manager.find(AlgoritmoUtilizzato.class,id);
    }
}
