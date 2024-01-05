package test;

import config.AppConfig;
import dao.AlgoritmoUtilizzatoDAO;
import dao.AlgoritmoUtilizzatoDAOInterface;
import entity.AlgoritmoUtilizzato;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.AlgoritmoUtilizzatoService;

public class TestDb {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AlgoritmoUtilizzatoService service= context.getBean(AlgoritmoUtilizzatoService.class);

        AlgoritmoUtilizzato input = new AlgoritmoUtilizzato("ilata","italia","Contains");
        service.insertRecord(input);
        System.out.println(service.findById(3));
        service.deleteRecord(3);
    }
}
