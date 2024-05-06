package com.systemdesign.designpatterns.singleton.singlethreaded;

public class Client {
    public static void main(String[] args) {
        SingletonClass singletonClass1 = SingletonClass.getInstance();
        SingletonClass singletonClass2 = SingletonClass.getInstance();
        System.out.println(System.identityHashCode(singletonClass1));
        System.out.println(System.identityHashCode(singletonClass2));
    }
}
