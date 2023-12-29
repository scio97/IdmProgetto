package com.example.progetto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class AlgoritmoContains extends Algoritmo{
    private Algoritmo next;

    public AlgoritmoContains(){
        next = new Levenshtein1();
    }

    @Override
    public String check (String input) {
        input = input.toLowerCase();
        for(int i=0; i<standardLista.size(); i++) {
            if(input.contains(standardLista.get(i)) || standardLista.get(i).contains(input)) {
                System.out.println("Contains--Stringa normalizzata trovata,input:"+input+ "  Stringa normalizzata: "+standardLista.get(i));
                return standardLista.get(i);
            }
        }
        System.out.println("Contains - Stringa non trovata,passo ad algoritmo successivo.");
        return next.check(input);
    }
}

