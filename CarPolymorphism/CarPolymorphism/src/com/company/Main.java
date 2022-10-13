package com.company;

import org.w3c.dom.ls.LSOutput;

class Car {
    private String name;
    private boolean engine;
    private int cylinders;
    private int wheels;

    public Car(String name, int cylinders) {
        this.name = name;
        this.engine = true;
        this.cylinders = cylinders;
        this.wheels = 4;
    }

    public void startEngine() {
        System.out.println("Car is starting");
    }

    public void accelerate() {
        System.out.println("Car is accelerating");
    }

    public void brake() {
        System.out.println("Car is stopping");
    }

    public String getName() {
        return name;
    }

    public int getCylinders() {
        return cylinders;
    }
}
class Volkswagen extends Car {
    public Volkswagen() {
        super("R32", 6);
    }

    @Override
    public void startEngine() {
        System.out.println("R32 is starting");

    }

    @Override
    public void accelerate() {
        System.out.println("R32 is accelerating");
    }

    @Override
    public void brake() {
        System.out.println("R32 is stopping");
    }
}
class Opel extends Car {
    public Opel() {
        super("Corsa", 4);
    }

    @Override
    public void accelerate() {
        System.out.println("Corsa is accelerating");
    }

    @Override
    public void startEngine() {
        System.out.println("Corsa is starting");
    }

    @Override
    public void brake() {
        System.out.println("Corsa is stopping");
    }
}
class Porsche extends Car {
    public Porsche() {
        super("Carrera", 4);
    }

    @Override
    public void brake() {
        System.out.println("Carrera is stopping");
    }

    @Override
    public void startEngine() {
        System.out.println("Carrera is starting");
    }

    @Override
    public void accelerate() {
        System.out.println("Carrera is accelerating");
    }
}

public class Main {

    public static void main(String[] args) {

        for (int i = 1; i < 8; i++) {
            Car car = randomCar();
            System.out.println("Call #" + i + "\n");
            car.accelerate();
            car.brake();
            car.startEngine();
            car.getName();

        }
    }

    public static Car randomCar () {
        int randomNumber = (int) (Math.random() * 2) + 1;
        System.out.println("Random number is " + randomNumber);
        switch (randomNumber) {
            case 1:
                return new Volkswagen();
            case 2:
                return new Opel();
            case 3:
                return new Porsche();
            default:
                return null;
        }
    }
}
