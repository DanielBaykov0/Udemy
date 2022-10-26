package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Array length: ");

        int minimum = findMin(readIntegers(scanner.nextInt()));

        System.out.println("Min elements is: " + minimum);

    }

    private static int[] readIntegers(int count) {

        int[] array = new int[count];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + " :");
            array[i] = scanner.nextInt();
        }

        return array;
    }

    private static int findMin(int[] array) {

        int min = array[0];

        for (int i = 0; i < array.length; i++) {

            if (min > array[i]) {
                min = array[i];
            }
        }

        return min;
    }
}
