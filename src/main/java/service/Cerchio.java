package service;

import org.springframework.stereotype.Component;

@Component
public class Cerchio {
    private int raggio=3;

    public Cerchio(){}

    @Override
    public String toString() {
        return "Cerchio{" +
                "raggio=" + raggio +
                '}';
    }
}
