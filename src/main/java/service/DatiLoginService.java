package service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import dao.DatiLoginDAO;
import entity.DatiLogin;

@Service
public class DatiLoginService {

	@PersistenceContext
	private EntityManager manager;
	private DatiLoginDAO datiLoginDAO;

	public DatiLoginService(EntityManager manager, DatiLoginDAO datiLoginDAO) {
		this.manager = manager;
		this.datiLoginDAO = datiLoginDAO;
	}
	@Transactional
	public void insertDato(DatiLogin dato) {
		try {
			// Verifica se l'username è già presente
			if (findByUserName(dato.getUserName()) == null) {
				// Verifica la password 
				if(checkPassword(dato.getPassword())) {
					manager.getTransaction().begin();
					datiLoginDAO.create(dato);
					manager.getTransaction().commit();
					System.out.println("Dato inserito con successo.");
				}  else {
					System.out.println("Password non valida, deve contenere almeno un carattere Maiuscolo e un numero");
				}
			}else {
				System.out.println("L'username è già presente nel database.");
			}
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	@Transactional
	public DatiLogin findByUserName(String userName) {
		try {
			manager.getTransaction().begin();
			DatiLogin temp= datiLoginDAO.findByUserName(userName.toLowerCase());
			manager.getTransaction().commit();
			return temp;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	@Transactional
	public void deleteDato(String user) {
		try {
			manager.getTransaction().begin();
			datiLoginDAO.delete(datiLoginDAO.findByUserName(user));
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
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
				manager.getTransaction().begin();
				DatiLogin temp = datiLoginDAO.findByUserName(user.toLowerCase());
				if (temp!=null) {
					temp.setPassword(pass);
					datiLoginDAO.update(temp);
					manager.getTransaction().commit();
					System.out.println("Password modificata con successo!");
				} else {
					System.out.println("Utente non trovato");
				}
			} else {
				System.out.println("Password non valida, riprova!");
			}
		} catch (Exception e) {
			manager.getTransaction().rollback();
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
