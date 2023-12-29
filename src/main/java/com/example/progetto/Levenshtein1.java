package com.example.progetto;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

public class Levenshtein1 extends Algoritmo{

    private Algoritmo next;
    public Levenshtein1(){
        next = new Levenshtein2();
    }

    @Override
    public String check(String input) {
        input = input.toLowerCase();
        for(int i=0; i<standardLista.size(); i++) {
            if(calculateLevenshteinDistance(input,standardLista.get(i)) < 2) {
                System.out.println("Levenshtein1-Stringa normalizzata trovata,input:"+input+ "  Stringa normalizzata: "+standardLista.get(i));
                return standardLista.get(i);
            }
        }
        System.out.println("Levenshtein1 - Stringa non trovata,passo ad algoritmo successivo.");
        return next.check(input);
    }

    public static int calculateLevenshteinDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = min(dp[i - 1][j - 1] + costOfSubstitution(s1.charAt(i - 1), s2.charAt(j - 1)),
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }

    public static int min(int... numbers) {
        return Arrays.stream(numbers)
                .min().orElse(Integer.MAX_VALUE);
    }
}

