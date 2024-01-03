package com.example.progetto;

import dao.AlgoritmoUtilizzatoDAO;
import entity.AlgoritmoUtilizzato;
import service.AlgoritmoUtilizzatoService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public abstract class Algoritmo {
    private Algoritmo next=null;

    /*protected List<String> standardLista = Arrays.asList(
            "italia", "stati uniti", "francia", "germania", "cina",
            "giappone", "brasile", "india", "canada", "australia"
    );*/

    public void setNext(Algoritmo next){
        this.next = next;
    }

    public String checkPresente(String input){
        EntityManager manager = null;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        manager = factory.createEntityManager();
        AlgoritmoUtilizzatoDAO dao = new AlgoritmoUtilizzatoDAO(manager);
        AlgoritmoUtilizzatoService service = new AlgoritmoUtilizzatoService(manager,dao);

        input = input.toLowerCase();
        List<AlgoritmoUtilizzato> lista= service.getListaAlgoritmoUtilizzato();
        for(AlgoritmoUtilizzato algoritmo : lista){
            if(algoritmo.getInput().equals(input)){
                return algoritmo.getOutput();
            }
        }
        return null;
    }

    public final String check (String input, List<String> standardLista) {
        EntityManager manager = null;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        manager = factory.createEntityManager();
        AlgoritmoUtilizzatoDAO dao = new AlgoritmoUtilizzatoDAO(manager);
        AlgoritmoUtilizzatoService service = new AlgoritmoUtilizzatoService(manager,dao);

        input = input.toLowerCase();

        if(checkPresente(input)!=null){
            System.out.println("Input giá trovato nel database,utlimo risultato: "+checkPresente(input));
            return checkPresente(input);
        }

        for(String standard : standardLista) {
            if(standard.equals(input)){
                System.out.println("Stringa inserita correttamente.");
                return standard;
            }

            if(checkInternal(input,standard)) {
                System.out.println(this.getClass().getSimpleName()+" -Stringa trovata: "+ standard +" , esecuzione finita");
                service.insertRecord(new AlgoritmoUtilizzato(input,standard,this.getClass().getSimpleName()));
                return standard;
            }
        }
        System.out.println(this.getClass().getSimpleName()+" -Stringa non trovata,passo ad algoritmo successivo.");
        if(next!=null){
            return next.check(input,standardLista);
        }
        else{
            service.insertRecord(new AlgoritmoUtilizzato(input,"nessun risultato",null));
            System.out.println("Lista algoritmi terminata,risultato non trovato");
            return null;
        }
    }

    protected abstract boolean checkInternal(String input,String standard);

}