package test;

import com.example.progetto.Algoritmo;
import com.example.progetto.AlgoritmoContains;
import dao.StandardStringDAO;
import entity.StandardString;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.StandardStringService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {

    public static void main(String[] args) {

        /*ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Algoritmo algoritmo = (AlgoritmoContains)context.getBean("contains");
        String input1 = "ITALIE";
        algoritmo.check(input1);*/

        EntityManager manager = null;
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
            manager = factory.createEntityManager();
            System.out.println("provaprovaprova");
            StandardString stringa = new StandardString();
            stringa.setValue("italia");
            StandardStringDAO dao = new StandardStringDAO(manager);
            StandardStringService service = new StandardStringService(manager,dao);

            stringa=service.findById(1);
            service.deleteStringa(stringa.getId());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (manager != null && manager.isOpen()) {
                manager.close();
            }
        }

    }
}
