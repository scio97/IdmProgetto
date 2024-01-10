package com.marcoarcarisi.demo.dao;

import com.marcoarcarisi.demo.entity.DatiLogin;
import org.springframework.stereotype.Repository;

@Repository
public interface DatiLoginDAOInterface extends DAOInterface<DatiLogin>{
	
	public DatiLogin findByUserName(String userName);

}
