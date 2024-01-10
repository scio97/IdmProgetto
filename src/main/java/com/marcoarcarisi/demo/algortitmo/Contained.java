package com.marcoarcarisi.demo.algortitmo;

public class Contained extends Algoritmo{
    public Contained(){}

    @Override
    protected boolean checkInternal(String input, String standard) {
        return standard.contains(input);
    }
}
