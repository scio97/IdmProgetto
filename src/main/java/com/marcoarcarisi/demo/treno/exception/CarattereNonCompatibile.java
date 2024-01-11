package com.marcoarcarisi.demo.treno.exception;

public class CarattereNonCompatibile extends TrenoException {
    private String sigla;
    private String suggerimento;

    public CarattereNonCompatibile(String sigla) {
        super("Utilizzo di caratteri diversi da (H,C,P,R)", sigla);
        String temp = "";

        for(int i = 0; i < sigla.length(); ++i) {
            if (sigla.charAt(i) == 'C' || sigla.charAt(i) == 'P' || sigla.charAt(i) == 'R'|| sigla.charAt(i) == 'H') {
                temp = temp + sigla.charAt(i);
            }
        }

        this.suggerimento = "Rimuovere i caratteri non consenstiti, esempio: " + temp;
    }

    public String getSigla() {
        return this.sigla;
    }

    public String getSuggerimento() {
        return this.suggerimento;
    }
}