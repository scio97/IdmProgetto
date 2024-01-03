package test;

import com.example.progetto.*;
import dao.StandardStringDAO;
import entity.DatiLogin;
import entity.StandardString;
import service.StandardStringService;
import service.DatiLoginService;
import dao.DatiLoginDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        /*ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Algoritmo algoritmo = (AlgoritmoContains)context.getBean("contains");
        String input1 = "ITALIE";
        algoritmo.check(input1);*/
        EntityManager manager = null;
        try {
            //creo gli algoritmi
            Algoritmo contains = new Contains();
            Algoritmo contained = new Contained();
            Algoritmo lev1 = new Levenshtein1();
            Algoritmo lev2 = new Levenshtein2();

            //decido l'ordine di esecuzione
            contains.setNext(contained);
            contained.setNext(lev1);
            lev1.setNext(lev2);
            //creo gli elementi necessari per la gestione del DB
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
            manager = factory.createEntityManager();
            StandardStringDAO dao = new StandardStringDAO(manager);
            StandardStringService service = new StandardStringService(manager,dao);
            /*service.insertStringa(new StandardString("italia"));
            service.insertStringa(new StandardString("danimarca"));
            service.insertStringa(new StandardString("francia"));
            service.insertStringa(new StandardString("germania"));
            service.insertStringa(new StandardString("canada"));
            service.insertStringa(new StandardString("irlanda"));
            service.insertStringa(new StandardString("spagna"));
            service.insertStringa(new StandardString("portogallo"));
            service.insertStringa(new StandardString("cina"));*/
            
            DatiLoginDAO dao1 = new DatiLoginDAO(manager);
            DatiLoginService login = new DatiLoginService(manager, dao1);
            
            //login.insertDato(new DatiLogin("utente1", "password1", "admin"));
            //login.insertDato(new DatiLogin("utente2", "password2", "base"));
            
            //login.deleteDato(1);

            List<String> listaPaesi = service.getListaStrings();

            //System.out.println("lista nazioni: "+ lista);

            contains.check("china",listaPaesi);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (manager != null && manager.isOpen()) {
                manager.close();
            }
        }

    }
}
