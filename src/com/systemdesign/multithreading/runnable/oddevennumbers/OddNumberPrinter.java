package com.systemdesign.multithreading.runnable.oddevennumbers;

import java.util.concurrent.Semaphore;

public class OddNumberPrinter implements Runnable {

    private Number number;

    private Semaphore oddSemaphore;

    private Semaphore evenSemaphore;

    public OddNumberPrinter(Number number, Semaphore oddSemaphore, Semaphore evenSemaphore) {
        this.number = number;
        this.oddSemaphore = oddSemaphore;
        this.evenSemaphore = evenSemaphore;
    }

    @Override
    public void run() {
        while (number.value < number.size) {
            try {
                oddSemaphore.acquire();
                if (number.value < number.size) {
                    number.value++;
                    System.out.println(number.value);
                }
                evenSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
