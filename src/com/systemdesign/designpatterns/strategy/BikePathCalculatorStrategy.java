package com.systemdesign.designpatterns.strategy;

public class BikePathCalculatorStrategy implements PathCalculatorStrategy {
    @Override
    public void findPath(String source, String destination) {
        System.out.println("Calculating bike path from source: " + source + " to: " + destination);
    }
}
