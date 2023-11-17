package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println(isEvenNumber(15));
        System.out.println(isEvenNumber(10));

        int count =1;
        while (count != 6) {
            System.out.println("Count value is " + count);
            count++;
        }
        // While doesn't execute always !
        count = 1;
        while (true) {
            if (count == 6) {
                break;
            }
            System.out.println("Count value is " + count);
            count++;
        }
        // Do while will always execute at least once !
        count = 1;
        do {
            System.out.println("Count value was " + count);
            count++;
        } while (count != 6);

        int number = 4;
        int finishNumber = 20;
        int evenNumbers = 0;

        while (number <= finishNumber) {
            number++;
            if (!isEvenNumber(number)) {
                continue;
            }
            System.out.println("Even number " + number);
            evenNumbers++;
            if (evenNumbers == 5) {
                break;
            }
        }
        System.out.println("Even number count = " + evenNumbers);
    }
    public static boolean isEvenNumber (int number) {
        if (number % 2 == 0) {
            return true;
        }else return false;
    }
}
