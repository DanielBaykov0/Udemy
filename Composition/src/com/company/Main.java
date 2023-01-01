package com.company;

public class Main {

    public static void main(String[] args) {
        Dimentions dimentions = new Dimentions(20,20,5);
        Case theCase = new Case("220B","Dell","360",dimentions);
        Monitor theMonitor = new Monitor("27 inch Beast", "Benq",27,new Resolution(1080,720));
        Motherboard theMotherboard = new Motherboard("BJ-200", "Asus",4,6,"v2.44");

        PC thePC = new PC(theCase, theMonitor, theMotherboard);
        thePC.getMonitor().drawPixelAt(820,540, "red");
        thePC.getMotherboard().loadProgram("Linux");
        thePC.getTheCase().pressPowerButton();

    }
}
