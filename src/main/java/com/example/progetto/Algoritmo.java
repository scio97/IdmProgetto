package com.example.progetto;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public abstract class Algoritmo {

    protected List<String> standardLista = Arrays.asList(
            "italia", "stati uniti", "francia", "germania", "cina",
            "giappone", "brasile", "india", "canada", "australia"
    );

    public abstract String check(String input);

}