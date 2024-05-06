package com.systemdesign.multithreading.runnable.numbertoprint;

public class NumberToPrint implements Runnable {

    private final int numberToPrint;

    public NumberToPrint(int numberToPrint) {
        this.numberToPrint = numberToPrint;
    }
    @Override
    public void run() {
        System.out.println(numberToPrint);
    }
}
