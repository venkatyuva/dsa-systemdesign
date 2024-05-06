package com.systemdesign.polymorphism;

public class Client {
    public static void main(String[] args) {
        A a = new A();
        a.doSomething();
        System.out.println("=====================");
        a = new B();
        a.doSomething();
    }
}
