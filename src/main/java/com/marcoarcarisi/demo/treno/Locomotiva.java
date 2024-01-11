package com.marcoarcarisi.demo.treno;

public class Locomotiva implements Vagone {
    private double peso = 900.0;
    private double pesoTrainabile = 10000.0;
    private double lunghezza = 4.0;

    public Locomotiva() {
    }

    public double getPeso() {
        return this.peso;
    }

    public double getPesoTrainabile() {
        return this.pesoTrainabile;
    }

    public double getLunghezza() {
        return this.lunghezza;
    }

    public String toString() {
        double var10000 = this.getPesoTrainabile();
        return "Locomotiva{pesoTrainabile: " + var10000 + "peso= " + this.getPeso() + "lunghezza=" + this.getLunghezza() + "}";
    }
}