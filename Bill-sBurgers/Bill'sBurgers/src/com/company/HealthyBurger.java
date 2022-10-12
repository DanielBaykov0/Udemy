package com.company;

public class HealthyBurger extends Hamburger{

    private String corn;
    private double cornPrice;
    private String peas;
    private double peasPrice;

    public HealthyBurger(String meat, double hamburgerBasePrice) {
        super("Healthy", "brown rye bread roll", meat, hamburgerBasePrice);
    }

    public void addCorn (String name, double price) {
        this.cornPrice = price;
        corn = name;
    }

    public void addPeas(String name, double price) {
        this.peasPrice = price;
        peas = name;
    }

    @Override
    public double hamburger() {
        double healthyHamburgerPrice = super.hamburger();
        if (this.corn != null) {
            healthyHamburgerPrice += this.cornPrice;
            System.out.println("Added " + this.corn + " for extra " + this.cornPrice);
        }
        if (this.peas != null) {
            healthyHamburgerPrice += this.peasPrice;
            System.out.println("Added " + this.peas + " for extra " + this.peasPrice);
        }
        return healthyHamburgerPrice;
    }
}
