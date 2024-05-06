package com.systemdesign.designpatterns.strategy;

public class CarPathCalculatorStrategy implements PathCalculatorStrategy {
    @Override
    public void findPath(String source, String destination) {
        System.out.println("Calculating car path from source: " + source + " to: " + destination);
    }
}
