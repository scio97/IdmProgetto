package com.marcoarcarisi.demo.treno;

public class Passeggero implements Vagone {
    private int posti = 50;
    private double peso = 600.0;
    private double lunghezza = 6.0;

    public Passeggero() {
    }

    public double getPeso() {
        return this.peso;
    }

    public double getLunghezza() {
        return this.lunghezza;
    }

    public int getPosti() {
        return this.posti;
    }

    public String toString() {
        int var10000 = this.getPosti();
        return "Vagone passeggeri{posti= " + var10000 + "peso= " + this.getPeso() + "lunghezza=" + this.getLunghezza() + "}";
    }
}
