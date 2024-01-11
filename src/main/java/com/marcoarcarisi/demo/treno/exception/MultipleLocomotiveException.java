package com.marcoarcarisi.demo.treno.exception;

public class MultipleLocomotiveException extends TrenoException{

    private String sigla;
    private String suggerimento;

    public MultipleLocomotiveException(String sigla){
        super("Puó esistere una solo Locomotiva per treno",sigla);

        String temp ="H";

        for(int i = 1; i < sigla.length(); ++i) {
            if (sigla.charAt(i) == 'C' || sigla.charAt(i) == 'P' || sigla.charAt(i) == 'R') {
                temp = temp + sigla.charAt(i);
            }
        }
        suggerimento = temp;
    }

    public String getSigla() {
        return this.sigla;
    }

    @Override
    public String getSuggerimento() {
        return this.suggerimento;
    }


}
