package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import dao.DatiLoginDAO;
import entity.DatiLogin;
import service.DatiLoginService;

public class TestLogin {

	public static void main(String[] args) {
		EntityManager manager = null;

		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
			manager = factory.createEntityManager();
			DatiLoginDAO dao1 = new DatiLoginDAO(manager);
			DatiLoginService login = new DatiLoginService(manager, dao1);

			//login.insertDato(new DatiLogin("utente1", "password1", "admin"));
			login.insertDato(new DatiLogin("utente2", "password2", "base"));
			login.insertDato(new DatiLogin("utente3", "password3", "base"));
			login.insertDato(new DatiLogin("utente5", "Password0123", "admin"));
			login.deleteDato("utente2");
			login.updatePassword("utente99", "Password123");
			login.effettuaAccesso("utente1", "Password123");
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (manager != null && manager.isOpen()) {
				manager.close();
			}
		}
	}
}
