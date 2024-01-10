package com.marcoarcarisi.demo.algortitmo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Rettangolo {
    private int base;

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
                '}';
    }
}
