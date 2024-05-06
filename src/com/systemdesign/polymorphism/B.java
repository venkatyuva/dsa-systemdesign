package com.systemdesign.polymorphism;

public class B extends A {
    public String company;

    @Override
    public void doSomething() {
        System.out.println("Company: " + company);
    }
}
