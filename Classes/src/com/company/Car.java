package com.company;

import java.util.Locale;

public class Car {

    private int door;
    private int wheels;
    private String model;
    private String engine;
    private String colour;

    public void setModel (String model) {
        String validModel = model.toLowerCase();
        if (validModel.equals("911") || validModel.equals("corsa")) {
            this.model = model;
        } else {
            this.model = "Unknown";
        }
    }
    public String getModel () {
        return this.model;
    }
}
