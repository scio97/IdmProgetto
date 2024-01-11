package com.marcoarcarisi.demo.treno.exception;


import java.io.PrintStream;

public class PosizioneRistoranteException extends TrenoException {
    private String sigla;
    private String suggerimento;

    public PosizioneRistoranteException(String sigla) {
        super("Il ristorante va posizionato al centro dei vagoni", sigla);
        String temp = "";
        int centrale = sigla.length() / 2;
        System.out.println("centrale: " + centrale);

        for(int i = 0; i < sigla.length(); ++i) {
            if (sigla.charAt(i) == 'R') {
                System.out.println("Salto la R e i++");
                ++i;
            }

            if (i < sigla.length()) {
                if (i == centrale) {
                    temp = temp + "R";
                    System.out.println("Aggiungo R");
                }

                temp = temp + sigla.charAt(i);
                PrintStream var10000 = System.out;
                char var10001 = sigla.charAt(i);
                var10000.println("Aggiungo " + var10001 + " Da posizione:" + i);
            }
        }

        this.suggerimento = "Prova a spostare il ristorante cosi: " + temp;
    }

    public String getSigla() {
        return this.sigla;
    }

    public String getSuggerimento() {
        return this.suggerimento;
    }
}