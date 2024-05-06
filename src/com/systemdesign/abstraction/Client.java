package com.systemdesign.abstraction;

public class Client {
    public static void main(String[] args) {
        AbstractClass abstractClass = new ChildClass();
        abstractClass.callTestAbstractMethod();
    }
}
