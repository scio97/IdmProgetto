package dao;

import entity.StandardString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
        manager.persist(ref);
    }

    @Override
    public List<StandardString> retrieve() {
        return manager.createQuery("select x from StandardString x", StandardString.class).getResultList();
    }

    @Override
    public void update(StandardString ref) {
        manager.persist(ref);
    }

    @Override
    public void delete(StandardString ref) {
        manager.remove(ref);
    }

    @Override
    public StandardString findById(int id){
        return manager.find(StandardString.class,id);
    }
}
