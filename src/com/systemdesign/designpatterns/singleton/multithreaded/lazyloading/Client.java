package com.systemdesign.designpatterns.singleton.multithreaded.lazyloading;

public class Client {
    public static void main(String[] args) {
        new Thread(() -> {
            LazyLoadingSingletonClass lazyLoadingSingletonClass = LazyLoadingSingletonClass.getInstance();
            System.out.println("Thread1: " + System.identityHashCode(lazyLoadingSingletonClass));
        }).start();

        new Thread(() -> {
            LazyLoadingSingletonClass lazyLoadingSingletonClass = LazyLoadingSingletonClass.getInstance();
            System.out.println("Thread2: " + System.identityHashCode(lazyLoadingSingletonClass));
        }).start();
    }
}
