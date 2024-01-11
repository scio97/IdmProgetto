package com.marcoarcarisi.demo.dao;

import com.marcoarcarisi.demo.entity.TreniCreati;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TreniCreatiDAO  implements TreniCreatiDAOInterface{

    @PersistenceContext
    private EntityManager manager;

    public TreniCreatiDAO(EntityManager manager){
        this.manager = manager;
    }

    @Override
    public void create(TreniCreati ref) {
        manager.getTransaction().begin();
        manager.persist(ref);
        manager.getTransaction().commit();
    }

    @Override
    public List<TreniCreati> retrieve() {
        return manager.createQuery("select x from TreniCreati x", TreniCreati.class).getResultList();
    }

    @Override
    public void update(TreniCreati ref) {
        manager.getTransaction().begin();
        manager.persist(ref);
        manager.getTransaction().commit();
    }

    @Override
    public void delete(TreniCreati ref) {
        manager.getTransaction().begin();
        manager.remove(ref);
        manager.getTransaction().commit();
    }

    public TreniCreati findById(int id){
        return manager.find(TreniCreati.class,id);
    }
}