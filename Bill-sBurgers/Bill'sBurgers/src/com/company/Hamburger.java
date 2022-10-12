package com.company;

public class Hamburger {

    private String name;
    private String breadRollType;
    private String meat;
    private String lettuce;
    private double lettucePrice;
    private String tomato;
    private double tomatoPrice;
    private String cucumber;
    private double cucumberPrice;
    private String cabbage;
    private double cabbagePrice;
    private double hamburgerBasePrice;

    public Hamburger(String name, String breadRollType, String meat, double hamburgerBasePrice) {
        this.name = name;
        this.breadRollType = breadRollType;
        this.meat = meat;
        this.hamburgerBasePrice = hamburgerBasePrice;
    }

    public void addLettuce(String name, double price) {
        this.lettucePrice = price;
        lettuce = name;
    }

    public void addTomato(String name, double price) {
        this.tomatoPrice = price;
        tomato = name;
    }

    public void addCucumber(String name, double price) {
        this.cucumberPrice = price;
        cucumber = name;
    }

    public void addCabbage(String name, double price) {
        this.cabbagePrice = price;
        cabbage = name;
    }

    public double hamburger() {
        double hamburgerPrice = this.hamburgerBasePrice;
        System.out.println(this.name + " hamburger with a " + this.breadRollType + " roll with " +
                        this.meat + " and the price is " + this.hamburgerBasePrice);
        if (this.lettuce != null) {
            hamburgerPrice += this.lettucePrice;
            System.out.println("Added " + this.lettuce + " for extra " + this.lettucePrice);
        }
        if (this.tomato != null) {
            hamburgerPrice += this.tomatoPrice;
            System.out.println("Added " + this.tomato + " for extra " + this.tomatoPrice);
        }
        if (this.cucumber != null) {
            hamburgerPrice += this.cucumberPrice;
            System.out.println("Added " + this.cucumber + " for extra " + this.cucumberPrice);
        }
        if (this.cabbage != null) {
            hamburgerPrice += this.cabbagePrice;
            System.out.println("Added " + this.cabbage + " for extra " + this.cabbagePrice);
        }
        return hamburgerPrice;
    }
}
