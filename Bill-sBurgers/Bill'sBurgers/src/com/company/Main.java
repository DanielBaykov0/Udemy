package com.company;

public class Main {

    public static void main(String[] args) {

        Hamburger hamburger = new Hamburger("Standart", "White","Pork", 3.20);
        hamburger.addLettuce("Lettuce", 0.14);
        System.out.println(hamburger.hamburger());


    }
}
