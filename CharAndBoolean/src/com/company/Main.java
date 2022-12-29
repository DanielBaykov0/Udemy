package com.company;

public class Main {

    public static void main(String[] args) {

        char myChar = 'D';
        //Char is 16 bites or 2 bytes
        char myUnicodeChar = '\u0044';
        System.out.println(myChar);
        System.out.println(myUnicodeChar);
        char myCopyrightChar = '\u00A9';
        System.out.println(myCopyrightChar);

        //Boolean is True or False, Yes or No, 1 or 0. In Java boolean is True or False only.
        boolean myTrueBooleanValue = true;
        boolean myFalseBooleanValue = false;

        boolean isCustomerOverTwentyOne = true;
    }
}
