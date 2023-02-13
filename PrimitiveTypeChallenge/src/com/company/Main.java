package com.company;

public class Main {

    public static void main(String[] args) {
        byte byteChallenge = 24;
        short shortChallenge = 1432;
        int intChallenge = 24567;
        int sum = byteChallenge + shortChallenge + intChallenge;
        long longChallenge = 50000 + (10 * sum);
        System.out.println(longChallenge);
    }
}
