package dao;

import entity.AlgoritmoUtilizzato;
import org.springframework.stereotype.Repository;

@Repository
public interface AlgoritmoUtilizzatoDAOInterface extends DAOInterface<AlgoritmoUtilizzato> {
	
    public AlgoritmoUtilizzato findById(int id);
}
