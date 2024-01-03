package com.example.progetto;

public class Contains extends Algoritmo{

    public Contains(){}


    @Override
    protected boolean checkInternal(String input, String standard) {
        return input.contains(standard);
    }
}

