package dao;

import entity.StandardString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.orm.jpa.JpaTransactionManager;

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
