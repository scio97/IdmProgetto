package com.marcoarcarisi.demo.dao;

import com.marcoarcarisi.demo.entity.AlgoritmoUtilizzato;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class AlgoritmoUtilizzatoDAO implements AlgoritmoUtilizzatoDAOInterface{

    public AlgoritmoUtilizzatoDAO(EntityManager manager){
        this.manager = manager;
    }

    @PersistenceContext
    EntityManager manager;

    @Override
    public void create(AlgoritmoUtilizzato ref) {
        manager.getTransaction().begin();
        manager.persist(ref);
        manager.getTransaction().commit();
    }

    @Override
    public List<AlgoritmoUtilizzato> retrieve() {
        return manager.createQuery("select x from AlgoritmoUtilizzato x", AlgoritmoUtilizzato.class).getResultList();
    }

    @Override
    public void update(AlgoritmoUtilizzato ref) {
        manager.getTransaction().begin();
        manager.persist(ref);
        manager.getTransaction().commit();
    }

    @Override
    public void delete(AlgoritmoUtilizzato ref) {
        manager.getTransaction().begin();
        manager.remove(ref);
        manager.getTransaction().commit();
    }

    @Override
    public AlgoritmoUtilizzato findById(int id){
        return manager.find(AlgoritmoUtilizzato.class,id);
    }
}
