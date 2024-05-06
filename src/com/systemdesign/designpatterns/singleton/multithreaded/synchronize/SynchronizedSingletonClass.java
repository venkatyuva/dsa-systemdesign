package com.systemdesign.designpatterns.singleton.multithreaded.synchronize;

public class SynchronizedSingletonClass {

    private static SynchronizedSingletonClass instance = null;

    private SynchronizedSingletonClass() {
    }

    public static synchronized SynchronizedSingletonClass getInstance() {
        if (instance == null) {
            instance = new SynchronizedSingletonClass();
        }
        return instance;
    }
}
