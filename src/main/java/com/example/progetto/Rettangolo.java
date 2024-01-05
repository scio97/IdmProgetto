package com.example.progetto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.Cerchio;

@Component
public class Rettangolo {
    private int base;
    @Autowired
    private Cerchio foro;

    public Rettangolo(){
        base = 3;
    }

    public Rettangolo(int base) {
        this.base = base;
    }

    @Override
    public String toString() {
        return "Rettangolo{" +
                "base=" + base +
                ", foro=" + foro +
                '}';
    }
}
