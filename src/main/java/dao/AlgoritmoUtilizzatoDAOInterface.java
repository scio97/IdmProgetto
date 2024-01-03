package dao;

import entity.AlgoritmoUtilizzato;

public interface AlgoritmoUtilizzatoDAOInterface extends DAOInterface<AlgoritmoUtilizzato> {
	
    public AlgoritmoUtilizzato findById(int id);
}
