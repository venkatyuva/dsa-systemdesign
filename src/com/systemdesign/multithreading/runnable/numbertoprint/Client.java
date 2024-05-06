package com.systemdesign.multithreading.runnable.numbertoprint;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 1; i <= 100; i++) {
            NumberToPrint numberToPrint = new NumberToPrint(i);
            executorService.execute(numberToPrint);
        }
        executorService.shutdown();
    }
}
