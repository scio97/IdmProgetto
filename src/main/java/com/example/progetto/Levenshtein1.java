package com.example.progetto;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

public class Levenshtein1 extends LevenshteinBase{


    public Levenshtein1(){
        super(1);
    }
}

