package com.systemdesign.designpatterns.strategy;

public class WalkPathCalculatorStrategy implements PathCalculatorStrategy {
    @Override
    public void findPath(String source, String destination) {
        System.out.println("Calculating walk path from source: " + source + " to: " + destination);
    }
}
