package com.marcoarcarisi.demo.treno.exception;

public class PesoEccessivoException extends TrenoException {
    private String sigla;
    private String suggerimento = "Rimuovere dei vagoni.";

    public PesoEccessivoException(String sigla) {
        super("Il peso dei vagoni supera la capacita' di traino della locomotiva.", sigla);
    }

    public String getSigla() {
        return this.sigla;
    }

    public String getSuggerimento() {
        return this.suggerimento;
    }
}