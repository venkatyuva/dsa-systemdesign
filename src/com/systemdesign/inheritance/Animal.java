package com.systemdesign.inheritance;

public interface Animal {

    void eat();

    void walk();

    void run();

    default void sleep() {
        System.out.println("Animal is sleeping");
    }
}
