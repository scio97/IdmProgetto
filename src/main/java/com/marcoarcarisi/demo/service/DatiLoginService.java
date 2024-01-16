package com.marcoarcarisi.demo.service;

import com.marcoarcarisi.demo.dao.DatiLoginDAO;
import com.marcoarcarisi.demo.entity.DatiLogin;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class DatiLoginService {

	@Autowired
	private DatiLoginDAO datiLoginDAO;

	public int insertDato(DatiLogin dato) {
		try {
			// Verifica se l'username è già presente
			if (findByUserName(dato.getUserName()) == null) {
				// Verifica la password 
				if(checkPassword(dato.getPassword())) {
					String hashedPassword = BCrypt.hashpw(dato.getPassword(), BCrypt.gensalt());
					DatiLogin user = new DatiLogin(dato.getUserName(), hashedPassword, dato.getRuolo());
					datiLoginDAO.create(user);
					System.out.println("Dato inserito con successo.");
					return 0;
				}  else {
					System.out.println("Password non valida, deve contenere almeno un carattere Maiuscolo e un numero");
					return 2;
				}
			}else {
				System.out.println("L'username è già presente nel database.");
				return 1;
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public DatiLogin findByUserName(String userName) {
		try {
			DatiLogin temp= datiLoginDAO.findByUserName(userName.toLowerCase());
			return temp;
		} catch (Exception e) {
			throw e;
		}
	}

	public void deleteDato(String user) {
		try {
			datiLoginDAO.delete(datiLoginDAO.findByUserName(user));
		} catch (Exception e) {
			throw e;
		}
	}

	public boolean checkPassword(String pass) {
		boolean hasNumber = false;
		boolean hasUppercase = false;

		if (pass.length() >= 8 && pass.length() <= 20) {
			for (int i = 0; i < pass.length(); i++) {
				char c = pass.charAt(i);

				// Verifica se il carattere è un numero utilizzando il valore ASCII
				if (c >= '0' && c <= '9') {
					hasNumber = true;
				} 
				// Verifica se il carattere è una lettera maiuscola utilizzando il valore ASCII
				else if (c >= 'A' && c <= 'Z') {
					hasUppercase = true;
				}
			}
		}
		return hasNumber && hasUppercase;
	}

	public void updatePassword(String user, String pass){
		try {
			if (checkPassword(pass)) {
				DatiLogin temp = datiLoginDAO.findByUserName(user.toLowerCase());
				if (temp!=null) {
					String hashedPassword = BCrypt.hashpw(pass, BCrypt.gensalt());
					temp.setPassword(hashedPassword);
					datiLoginDAO.update(temp);
					System.out.println("Password modificata con successo!");
				} else {
					System.out.println("Utente non trovato");
				}
			} else {
				System.out.println("Password non valida, riprova!");
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public int effettuaAccesso(String user, String pass) {
		DatiLogin temp = datiLoginDAO.findByUserName(user.toLowerCase());
		if(temp!=null) {
			if(BCrypt.checkpw(pass, temp.getPassword())){
				System.out.println("Benvenuto "+user);
				return 0;
			} else {
				System.out.println("Password errata!");
				return 2;
			}
		} else {
			System.out.println("UserName errato!");
		} 
		return 1;
	}
}
