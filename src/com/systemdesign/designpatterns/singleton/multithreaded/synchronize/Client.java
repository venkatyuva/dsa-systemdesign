package com.systemdesign.designpatterns.singleton.multithreaded.synchronize;

public class Client {
    public static void main(String[] args) {
        new Thread(() -> {
            SynchronizedSingletonClass synchronizedSingletonClass = SynchronizedSingletonClass.getInstance();
            System.out.println("Thread1: " + System.identityHashCode(synchronizedSingletonClass));
        }).start();

        new Thread(() -> {
            SynchronizedSingletonClass synchronizedSingletonClass = SynchronizedSingletonClass.getInstance();
            System.out.println("Thread2: " + System.identityHashCode(synchronizedSingletonClass));
        }).start();
    }
}
