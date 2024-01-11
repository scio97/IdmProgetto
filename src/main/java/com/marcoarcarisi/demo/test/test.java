package com.marcoarcarisi.demo.test;

import com.marcoarcarisi.demo.treno.Treno;
import com.marcoarcarisi.demo.treno.exception.TrenoException;

public class test {
    public static void main(String[] args) {
        Treno choochoo = null;

        try {
            choochoo = new Treno("HPPPRPPPP");
        } catch (TrenoException var3) {
            System.out.println(var3.getMessage());
            System.out.println(var3.getSuggerimento());
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
