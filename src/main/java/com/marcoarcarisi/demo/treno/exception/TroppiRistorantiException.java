package com.marcoarcarisi.demo.treno.exception;

public class TroppiRistorantiException extends TrenoException {
    private String sigla;
    private String suggerimento;

    public TroppiRistorantiException(String sigla) {
        super("Ristoranti in eccesso", sigla);
        String temp = "";
        boolean trovata = false;

        for(int i = 0; i < sigla.length(); ++i) {
            if (sigla.charAt(i) == 'R' && !trovata) {
                trovata = true;
                temp = temp + sigla.charAt(i);
            } else if (sigla.charAt(i) != 'R') {
                temp = temp + sigla.charAt(i);
            }
        }

        this.suggerimento = "Si consiglia di rimuovere i vagoni ristorante in eccesso, esempio: " + temp;
    }

    public String getSigla() {
        return this.sigla;
    }

    public String getSuggerimento() {
        return this.suggerimento;
    }
}