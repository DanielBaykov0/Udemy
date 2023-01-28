package com.company;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int switchValue = 4;

        switch (switchValue) {
            case 1:
                System.out.println("Value was 1");
                break;
            case 2:
                System.out.println("Value was 2");
                break;
            case 3: case 4: case 5:
                System.out.println("Value was 3, 4 or 5");
                System.out.println("Actually it was a " + switchValue);
                break;
            default:
                System.out.println("Value was not 1 or 2");
                break;
        }
        char charValue = 'C';
        switch (charValue) {
            case 'A': case 'B': case 'C': case 'D': case 'E':
                System.out.println("It is A, B, C, D or E");
                System.out.println("Actually it's " + charValue);
                break;

            default:
                System.out.println("Not found ");
                break;
        }
        String month = "February";
        switch (month.toLowerCase(Locale.ROOT)) {
            case "october":
                System.out.println("Oct");
                break;
            case "february":
                System.out.println("Feb");
                break;
            default:
                System.out.println("W/e");
                break;
        }
    }
}
