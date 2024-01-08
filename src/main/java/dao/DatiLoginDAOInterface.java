package dao;

import entity.DatiLogin;
import org.springframework.stereotype.Repository;

@Repository
public interface DatiLoginDAOInterface extends DAOInterface<DatiLogin>{
	
	public DatiLogin findByUserName(String userName);

}
