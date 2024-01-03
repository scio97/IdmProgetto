package test;

import com.example.progetto.*;

public class AlgoritmoTest {
    public static void main0(String[] args) {
        Algoritmo contains = new Contains();
        Algoritmo contained = new Contained();
        Algoritmo lev1 = new Levenshtein1();
        Algoritmo lev2 = new Levenshtein2();

        contains.setNext(contained);
        contained.setNext(lev1);
        lev1.setNext(lev2);

        String input = "itale";

        //contains.check(input);
    }
}
