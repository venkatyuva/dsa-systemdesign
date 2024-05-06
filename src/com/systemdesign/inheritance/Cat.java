package com.systemdesign.inheritance;

public class Cat implements Animal {

    @Override
    public void eat() {
        System.out.println("Cat is eating");
    }

    @Override
    public void walk() {
        System.out.println("Cat is walking");
    }

    @Override
    public void run() {
        System.out.println("Cat is running");
    }

    public void meow() {
        System.out.println("Meow:)");
    }

    @Override
    public void sleep() {
        System.out.println("Meow is sleeping");
    }

    public static void staticMeow() {
        System.out.println("Static meow of Cat");
    }
}
