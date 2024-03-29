package com.marcoarcarisi.demo.algortitmo;



import com.marcoarcarisi.demo.entity.AlgoritmoUtilizzato;
import com.marcoarcarisi.demo.service.AlgoritmoUtilizzatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
@Component
public abstract class Algoritmo {
    private Algoritmo next=null;

    @Autowired
    private AlgoritmoUtilizzatoService service;

    public void setNext(Algoritmo next){
        this.next = next;
    }

    public String checkPresente(String input){
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

    @Override
    public String toString() {
        return "Algoritmo{" +
                ", service=" + service +
                '}';
    }
}