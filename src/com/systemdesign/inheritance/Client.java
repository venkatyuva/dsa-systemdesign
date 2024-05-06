package com.systemdesign.inheritance;

public class Client {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.eat();
        animal.walk();
        animal.run();
        animal.sleep();
        ((Dog) animal).bark();

        animal = new Cat();
        animal.eat();
        animal.run();
        animal.walk();
        animal.sleep();
        ((Cat) animal).meow();

        Cat cat = new PersianCat();
        cat.staticMeow();
    }
}
