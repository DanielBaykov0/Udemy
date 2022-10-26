package com.company;

import java.util.Scanner;

public class MinimumElement {
    private static Scanner scanner = new Scanner(System.in);
    private static int readInteger(){
        Scanner scanner = new Scanner(System.in);
        int capacity = scanner.nextInt();
        scanner.close();
        return capacity;
    }
    private static int[] readElements(int values){
        Scanner scanner = new Scanner(System.in);
        int[] elements = new int[values];
        for(int i=0; i<elements.length; i++){
            int totalElementEntered = scanner.nextInt();
            scanner.nextLine();
            elements[i] = totalElementEntered;

        }
        return elements;
    }
    private static int findMin(int[] count){
        int min = Integer.MAX_VALUE;
        for(int i=0; i< count.length; i++) {
            int minVal = count[i];
            if (minVal < min) {
                min = minVal;
            }
        }
        return min;
    }

}