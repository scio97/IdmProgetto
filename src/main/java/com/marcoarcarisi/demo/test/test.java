package com.marcoarcarisi.demo.test;

import com.marcoarcarisi.demo.treno.Treno;
import com.marcoarcarisi.demo.treno.exception.TrenoException;

public class test {
    public static void main(String[] args) {
        Treno choochoo = null;

        try {
            choochoo = new Treno("HPPPRPP");
        } catch (TrenoException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSuggerimento());
        }

        System.out.println(choochoo.toString());
        System.out.println("-----------------------------");
        System.out.println("Peso totale treno: " + choochoo.pesoTotale() + "Kg");
        System.out.println("-----------------------------");
        System.out.println("lunghezza totale treno: " + choochoo.lunghezzaTotale() + "m");
        System.out.println("-----------------------------");
        System.out.println("Velocita massima=" + choochoo.velocita() + "Km/h");
    }
}
