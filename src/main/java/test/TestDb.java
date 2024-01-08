package test;

import com.example.progetto.Algoritmo;
import config.AppConfig;
import dao.AlgoritmoUtilizzatoDAO;
import dao.AlgoritmoUtilizzatoDAOInterface;
import dao.StandardStringDAO;
import dao.StandardStringDaoInterface;
import entity.AlgoritmoUtilizzato;
import entity.StandardString;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.AlgoritmoUtilizzatoService;
import service.StandardStringService;

import java.util.List;

public class TestDb {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Algoritmo algoritmo = (Algoritmo)context.getBean("getAlgoritmo");

        StandardStringService service = context.getBean(StandardStringService.class);
        List<String> listaPaesi = service.getListaString();

        algoritmo.check("itlaia",listaPaesi);

        //AlgoritmoUtilizzatoService service= context.getBean(AlgoritmoUtilizzatoService.class);

        //AlgoritmoUtilizzato input = new AlgoritmoUtilizzato("ilata","italia","Contains");
        //service.insertRecord(input);
        //System.out.println(service.findById(3));
        //System.out.println(service.getListaAlgoritmoUtilizzato());
        //service.deleteRecord(3);
    }
}
