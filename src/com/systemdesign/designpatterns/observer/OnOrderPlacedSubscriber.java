package com.systemdesign.designpatterns.observer;

public interface OnOrderPlacedSubscriber {


    void subscribeFlipkart();

    void unsubscribeFlipkart();

    void announceOrderPlaced();
}
