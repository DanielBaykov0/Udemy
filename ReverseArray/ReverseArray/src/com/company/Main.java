package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] array = {5, 6, 9, 7, 14, 2, 18};

        System.out.println("Array = " + Arrays.toString(array));

        reverse(array);

        System.out.println("Reversed array = " + Arrays.toString(array));

    }

    private static void reverse(int[] array) {

        int max = array.length - 1;
        int halfLength = array.length / 2;
        for (int i = 0; i < halfLength; i++) {
            int temp = array[i];
            array[i] = array[max - i];
            array[max - i] = temp;
        }
    }
}
