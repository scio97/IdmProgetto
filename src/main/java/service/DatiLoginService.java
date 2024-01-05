package service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.DatiLoginDAO;
import entity.DatiLogin;

@Transactional
@Service
public class DatiLoginService {

	@Autowired
	private DatiLoginDAO datiLoginDAO;

	public void insertDato(DatiLogin dato) {
		try {
			// Verifica se l'username è già presente
			if (findByUserName(dato.getUserName()) == null) {
				// Verifica la password 
				if(checkPassword(dato.getPassword())) {
					datiLoginDAO.create(dato);
					System.out.println("Dato inserito con successo.");
				}  else {
					System.out.println("Password non valida, deve contenere almeno un carattere Maiuscolo e un numero");
				}
			}else {
				System.out.println("L'username è già presente nel database.");
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
					temp.setPassword(pass);
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

	public boolean effettuaAccesso(String user, String pass) {
		DatiLogin temp = datiLoginDAO.findByUserName(user.toLowerCase());
		if(temp!=null) {
			if(temp.getPassword().equals(pass)) {
				System.out.println("Benvenuto "+user);
				return true;
			} else {
				System.out.println("Password errata!");
			}
		} else {
			System.out.println("UserName errato!");
		} 
		return false;
	}
}
