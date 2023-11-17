package accessmodifiers;

interface Accessible { // the interface is accessible to all classes in package accessmodifiers
    int SOME_CONSTANT = 100; // all interface variables are public static final
    public void methodA(); // public
    void methodB(); // public cuz it is in the interface
    boolean methodC(); // public cuz it is in the interface 
}
