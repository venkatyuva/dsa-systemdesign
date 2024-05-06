package com.systemdesign.designpatterns.strategy;

public class PathCalculatorFactory {

    private static final CarPathCalculatorStrategy carPathCalculatorStrategy = new CarPathCalculatorStrategy();

    private static final BikePathCalculatorStrategy bikePathCalculatorStrategy = new BikePathCalculatorStrategy();

    private static final WalkPathCalculatorStrategy walkPathCalculatorStrategy = new WalkPathCalculatorStrategy();

    private static final TrainPathCalculatorStrategy trainPathCalculatorStrategy = new TrainPathCalculatorStrategy();

    public static PathCalculatorStrategy getPathCalculator(ModeOfTransportation mode) {
        if (ModeOfTransportation.CAR.equals(mode)) {
            return carPathCalculatorStrategy;
        } else if (ModeOfTransportation.BIKE.equals(mode)) {
            return bikePathCalculatorStrategy;
        } else if (ModeOfTransportation.WALK.equals(mode)) {
            return walkPathCalculatorStrategy;
        } else if (ModeOfTransportation.TRAIN.equals(mode)) {
            return trainPathCalculatorStrategy;
        }
        return null;
    }
}
