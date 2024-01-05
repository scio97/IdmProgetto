package test;

import com.example.progetto.*;
import config.AppConfig;
import dao.DatiLoginDAO;
import dao.StandardStringDAO;
import entity.DatiLogin;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.DatiLoginService;
import service.StandardStringService;
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

            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
            /*service.insertStringa(new StandardString("italia"));
            service.insertStringa(new StandardString("danimarca"));
            service.insertStringa(new StandardString("francia"));
            service.insertStringa(new StandardString("germania"));
            service.insertStringa(new StandardString("canada"));
            service.insertStringa(new StandardString("irlanda"));
            service.insertStringa(new StandardString("spagna"));
            service.insertStringa(new StandardString("portogallo"));
            service.insertStringa(new StandardString("cina"));*/
            //Algoritmo contains = (Algoritmo)context.getBean("contains");

            Rettangolo rettangolo = context.getBean(Rettangolo.class);
            System.out.println(rettangolo.toString());

            StandardStringService standardService = context.getBean(StandardStringService.class);
            Algoritmo algoritmo = context.getBean(AppConfig.class).getAlgoritmo();
            System.out.println(algoritmo.toString());
            //contains.setNext(contains2);
            List<String> listaPaesi = standardService.getListaStrings();

            algoritmo.check("ilatia",listaPaesi);

            /*DatiLoginService login = context.getBean(DatiLoginService.class);

			login.insertDato(new DatiLogin("utente1", "Password1", "admin"));
			login.insertDato(new DatiLogin("utente2", "Password2", "base"));
			login.insertDato(new DatiLogin("utente3", "Password3", "base"));
			login.insertDato(new DatiLogin("utente5", "Password0123", "base"));
			login.effettuaAccesso("utente5", "Password123");*/

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
