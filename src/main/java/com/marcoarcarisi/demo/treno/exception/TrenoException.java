package com.marcoarcarisi.demo.treno.exception;

public abstract class TrenoException extends RuntimeException {
    private String sigla;

    public TrenoException(String message, String sigla) {
        super(message);
    }

    public String getSigla() {
        return this.sigla;
    }

    public abstract String getSuggerimento();
}
