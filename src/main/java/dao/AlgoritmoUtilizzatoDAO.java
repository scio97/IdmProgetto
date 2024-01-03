package dao;

import com.example.progetto.Algoritmo;
import entity.AlgoritmoUtilizzato;
import entity.StandardString;

import javax.persistence.EntityManager;
import java.util.List;

public class AlgoritmoUtilizzatoDAO implements AlgoritmoUtilizzatoDAOInterface{
    private EntityManager manager;

    public AlgoritmoUtilizzatoDAO(EntityManager manager){
        this.manager = manager;
    }

    @Override
    public void create(AlgoritmoUtilizzato ref) {
        manager.persist(ref);
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
