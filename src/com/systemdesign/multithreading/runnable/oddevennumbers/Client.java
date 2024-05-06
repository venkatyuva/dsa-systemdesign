package com.systemdesign.multithreading.runnable.oddevennumbers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Number number = new Number(0, 10);
        Semaphore oddSemaphore = new Semaphore(1);
        oddSemaphore.release(2);
        Semaphore evenSemaphore = new Semaphore(0);
        OddNumberPrinter oddNumberPrinter = new OddNumberPrinter(number, oddSemaphore, evenSemaphore);
        EvenNumberPrinter evenNumberPrinter = new EvenNumberPrinter(number, oddSemaphore, evenSemaphore);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(oddNumberPrinter);
        executorService.execute(evenNumberPrinter);
        executorService.shutdown();
    }
}
