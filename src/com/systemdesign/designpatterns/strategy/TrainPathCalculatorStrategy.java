package com.systemdesign.designpatterns.strategy;

public class TrainPathCalculatorStrategy implements PathCalculatorStrategy {

    @Override
    public void findPath(String source, String destination) {
        System.out.println("Calculating train path from source: " + source + " to: " + destination);
    }
}
