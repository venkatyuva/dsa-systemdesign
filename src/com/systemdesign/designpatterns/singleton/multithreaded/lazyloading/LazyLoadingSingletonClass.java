package com.systemdesign.designpatterns.singleton.multithreaded.lazyloading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LazyLoadingSingletonClass {

    private static LazyLoadingSingletonClass instance = null;

    private static final Lock lock = new ReentrantLock();

    private LazyLoadingSingletonClass() {
    }

    public static LazyLoadingSingletonClass getInstance() {
        if (instance == null) {
            lock.lock();
            if (instance == null) {
                instance = new LazyLoadingSingletonClass();
            }
            lock.unlock();
        }
        return instance;
    }
}
