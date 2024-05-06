package com.systemdesign.designpatterns.singleton.multithreaded.eagerloading;

public class EagerLoadingSingletonClass {

    private static EagerLoadingSingletonClass instance = new EagerLoadingSingletonClass();

    private EagerLoadingSingletonClass() {
    }

    public static EagerLoadingSingletonClass getInstance() {
        return instance;
    }
}
