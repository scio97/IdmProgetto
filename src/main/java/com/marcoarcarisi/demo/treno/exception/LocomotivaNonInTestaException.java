package com.marcoarcarisi.demo.treno.exception;

public class LocomotivaNonInTestaException extends TrenoException {
    private String sigla;
    private String suggerimento;

    public LocomotivaNonInTestaException(String sigla) {
        super("Locomotiva non in testa", sigla);
        this.suggerimento = "Si consiglia di aggiungere una locomotiva in testa, ad esempio: H" + sigla;
    }

    public String getSigla() {
        return this.sigla;
    }

    public String getSuggerimento() {
        return this.suggerimento;
    }
}
