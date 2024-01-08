package test;

import com.example.progetto.*;
import config.AppConfig;
import dao.DatiLoginDAO;
import dao.StandardStringDAO;
import entity.AlgoritmoUtilizzato;
import entity.DatiLogin;
import entity.StandardString;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.AlgoritmoUtilizzatoService;
import service.DatiLoginService;
import service.ServiceInterface;
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

        try {

            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
            StandardStringService service = context.getBean(StandardStringService.class);
            /*service.insertStringa(new StandardString("italia"));
            service.insertStringa(new StandardString("danimarca"));
            service.insertStringa(new StandardString("francia"));
            service.insertStringa(new StandardString("germania"));
            service.insertStringa(new StandardString("canada"));
            service.insertStringa(new StandardString("irlanda"));
            service.insertStringa(new StandardString("spagna"));
            service.insertStringa(new StandardString("portogallo"));
            service.insertStringa(new StandardString("cina"));*/
            Algoritmo contains = (Algoritmo)context.getBean("contains");
            //service.insertStringa(new StandardString("uganda"));


            Algoritmo algoritmo = (Algoritmo)context.getBean("getAlgoritmo");
            System.out.println(algoritmo.toString());
            //contains.setNext(contains2);
            //standardService.insertStringa(new StandardString("austria"));
            List<String> listaPaesi = service.getListaString();
            System.out.println("Lista: "+listaPaesi);
            AlgoritmoUtilizzatoService algoritmoService = context.getBean(AlgoritmoUtilizzatoService.class);
            AlgoritmoUtilizzato alg = new AlgoritmoUtilizzato("germnana", "germania", "Levenshtain1");
            algoritmoService.insertRecord(alg);
            List<String> listaAlgoritmi = algoritmoService.getListaString();
            System.out.println(listaAlgoritmi);
            algoritmo.check("itaalia",listaPaesi);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
