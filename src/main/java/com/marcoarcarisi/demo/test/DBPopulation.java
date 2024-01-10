package com.marcoarcarisi.demo.test;

import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.marcoarcarisi.demo.entity.StandardString;
import com.marcoarcarisi.demo.service.AlgoritmoUtilizzatoService;
import com.marcoarcarisi.demo.service.StandardStringService;
import com.marcoarcarisi.demo.algortitmo.*;
import com.marcoarcarisi.demo.config.*;

public class DBPopulation {

	public static void main(String[] args) {
		
		try {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
            
            StandardStringService standardService = context.getBean(StandardStringService.class);

            // Inserisci alcuni dati di esempio
            /*
            standardService.insertStringa(new StandardString("italia"));
            standardService.insertStringa(new StandardString("danimarca"));
            standardService.insertStringa(new StandardString("francia"));
            standardService.insertStringa(new StandardString("germania"));
            standardService.insertStringa(new StandardString("canada"));
            standardService.insertStringa(new StandardString("irlanda"));
            standardService.insertStringa(new StandardString("spagna"));
            standardService.insertStringa(new StandardString("portogallo"));
            standardService.insertStringa(new StandardString("cina"));
            */
            standardService.insertStringa(new StandardString("spagna"));
            
            Algoritmo contains = (Algoritmo) context.getBean("contains");

            Algoritmo algoritmo = (Algoritmo) context.getBean("getAlgoritmo");
            System.out.println(algoritmo.toString());

            List<String> listaPaesi = standardService.getListaString();
            System.out.println("Lista: " + listaPaesi);

            AlgoritmoUtilizzatoService algoritmoService = context.getBean(AlgoritmoUtilizzatoService.class);
           

            List<String> listaAlgoritmi = algoritmoService.getListaString();
            System.out.println(listaAlgoritmi);

            algoritmo.check("itaalia", listaPaesi);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
