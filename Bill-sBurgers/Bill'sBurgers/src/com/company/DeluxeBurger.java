package com.company;

public class DeluxeBurger extends Hamburger{

    public DeluxeBurger() {
        super("Deluxe", "white", "chicken", 7.48);
        super.addLettuce("Chips", 1.63);
        super.addCabbage("Drink", 1.75);
    }

    @Override
    public void addLettuce(String name, double price) {
        System.out.println("Can not add additional items");
    }

    @Override
    public void addTomato(String name, double price) {
        System.out.println("Can not add additional items");
    }

    @Override
    public void addCucumber(String name, double price) {
        System.out.println("Can not add additional items");
    }

    @Override
    public void addCabbage(String name, double price) {
        System.out.println("Can not add additional items");
    }
}
