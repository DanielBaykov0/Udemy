package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int minnumber = Integer.MAX_VALUE;
        int maxnumber = Integer.MIN_VALUE;

        while (true) {
            System.out.println("Enter number: ");

            boolean hasNextInt = scanner.hasNextInt();

            if (hasNextInt) {
                int number = scanner.nextInt();

                if (number < minnumber) {
                    minnumber = number;
                }
                if (number > maxnumber) {
                    maxnumber = number;
                }
            }
            else {
                System.out.println("Invalid number");
                break;
            }
            scanner.nextLine();
        }
        System.out.println(minnumber + " " + maxnumber);
        scanner.close();
    }
}
