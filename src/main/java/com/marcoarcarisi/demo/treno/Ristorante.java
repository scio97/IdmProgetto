package com.marcoarcarisi.demo.treno;

public class Ristorante implements Vagone {
    private double peso;
    private double lunghezza;

    public Ristorante() {
    }

    public double getPeso() {
        return this.peso;
    }

    public double getLunghezza() {
        return this.lunghezza;
    }

    public String toString() {
        double var10000 = this.getPeso();
        return "Vagone Ristorante{peso= " + var10000 + "lunghezza=" + this.getLunghezza() + "}";
    }
}
