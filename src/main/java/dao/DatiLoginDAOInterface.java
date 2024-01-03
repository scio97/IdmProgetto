package dao;

import entity.DatiLogin;

public interface DatiLoginDAOInterface extends DAOInterface<DatiLogin>{
	
	public DatiLogin findByUserName(String userName);

}
