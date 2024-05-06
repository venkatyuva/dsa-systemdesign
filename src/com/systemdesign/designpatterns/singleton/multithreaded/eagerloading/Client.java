package com.systemdesign.designpatterns.singleton.multithreaded.eagerloading;

public class Client {
    public static void main(String[] args) {
        new Thread(() -> {
            EagerLoadingSingletonClass eagerLoadingSingletonClass = EagerLoadingSingletonClass.getInstance();
            System.out.println("Thread1: " + System.identityHashCode(eagerLoadingSingletonClass));
        }).start();

        new Thread(()->{
            EagerLoadingSingletonClass eagerLoadingSingletonClass = EagerLoadingSingletonClass.getInstance();
            System.out.println("Thread2: " + System.identityHashCode(eagerLoadingSingletonClass));
        }).start();
    }
}
