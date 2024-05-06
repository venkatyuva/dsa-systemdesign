package com.systemdesign.multithreading.runnable.oddevennumbers;

import java.util.concurrent.Semaphore;

public class EvenNumberPrinter implements Runnable {

    private Number number;

    private Semaphore oddSemaphore;

    private Semaphore evenSemaphore;

    public EvenNumberPrinter(Number number, Semaphore oddSemaphore, Semaphore evenSemaphore) {
        this.number = number;
        this.oddSemaphore = oddSemaphore;
        this.evenSemaphore = evenSemaphore;
    }

    @Override
    public void run() {
        while (number.value < number.size) {
            try {
                evenSemaphore.acquire();
                if (number.value < number.size) {
                    number.value++;
                    System.out.println(number.value);
                }
                oddSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
