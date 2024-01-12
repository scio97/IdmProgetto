package com.marcoarcarisi.demo.treno;

public class Cargo implements Vagone {
    private double peso = 1600.0;
    private double lunghezza = 10.0;

    public char tipo(){
        return 'C';
    }

    public Cargo() {
    }

    public double getPeso() {
        return this.peso;
    }

    public double getLunghezza() {
        return this.lunghezza;
    }

    public String toString() {
        double var10000 = this.getPeso();
        return "Vagone cargo{peso= " + var10000 + "lunghezza=" + this.getLunghezza() + "}";
    }
}
