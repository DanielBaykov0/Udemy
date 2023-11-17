package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("10,000 at 2% interest = " + calculateInterest(10000.0, 2.0));
        System.out.println("10,000 at 3% interest = " + calculateInterest(10000.0, 3.0));
        System.out.println("10,000 at 4% interest = " + calculateInterest(10000.0, 4.0));
        System.out.println("10,000 at 5% interest = " + calculateInterest(10000.0, 5.0));

        for (int i = 0; i < 5; i++) {
            System.out.println("Loop " + i);
        }

        for (double i = 2.0; i < 9.0; i++) {
            System.out.println("Interest " + String.format("%.2f", calculateInterest(10000.0, i)));
        }

        for (double i = 8.0; i > 1.0; i--) {
            System.out.println("Interest " + String.format("%.2f", calculateInterest(10000.0, i)));
        }
        int count = 0;
        for (int i = 2; i < 10; i++) {
            if (isPrime(i)) {
                count++;
                System.out.println(i + " is a prime number ");
                if (count ==3) {
                    System.out.println("End of loop");
                    break;
                }
            }
        }

    }

    public static double calculateInterest(double amount, double interestRate) {
        return (amount * (interestRate / 100));
    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % 2 == 0) {
                return false;
            }
        }
        return true;
    }
}
