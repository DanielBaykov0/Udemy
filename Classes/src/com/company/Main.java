package com.company;

public class Main {

    public static void main(String[] args) {

        Car porsche = new Car();
        Car opel = new Car();
        System.out.println("Model is " + porsche.getModel());
        porsche.setModel("911");
        System.out.println("Model is " + porsche.getModel());
    }
}
