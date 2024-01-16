package com.marcoarcarisi.demo.dao;

import com.marcoarcarisi.demo.entity.StandardString;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class StandardStringDAO implements StandardStringDaoInterface{

    @PersistenceContext
    private EntityManager manager;

    public StandardStringDAO(EntityManager manager){
        this.manager = manager;
    }

    @Override
    public void create(StandardString ref) {
        manager.getTransaction().begin();
        manager.persist(ref);
        manager.getTransaction().commit();
    }

    @Override
    public List<StandardString> retrieve() {
        System.out.println("Manager: " + manager );
        return manager.createQuery("select x from StandardString x", StandardString.class).getResultList();
    }

    @Override
    public void update(StandardString ref) {
        manager.getTransaction().begin();
        manager.persist(ref);
        manager.getTransaction().commit();
    }

    @Override
    public void delete(StandardString ref) {
        manager.getTransaction().begin();
        manager.remove(ref);
        manager.getTransaction().commit();
    }

    @Override
    public StandardString findById(int id){
        return manager.find(StandardString.class,id);
    }

    public StandardString findByPaese(String paese) {
        TypedQuery<StandardString> query = manager.createQuery(
                "SELECT s FROM StandardString s WHERE s.valore = :paese", StandardString.class);
        query.setParameter("paese", paese);

        List<StandardString> results = query.getResultList();

        return results.isEmpty() ? null : results.get(0);
    }
}
