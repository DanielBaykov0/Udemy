package inheritanceanimal;

public class Main {
    public static void main(String[] args) {

        Animal animal = new Animal("inheritanceanimal.Animal", 1,1,5,5);
        Dog dog = new Dog("Yorkie", 8,20,2,4,1,20,"long silky");
        dog.eat();
        dog.walk();
        dog.run();
    }
}
