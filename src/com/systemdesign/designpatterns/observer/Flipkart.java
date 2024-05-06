package com.systemdesign.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Flipkart {

    private static Flipkart instance = null;

    private final List<OnOrderPlacedSubscriber> subscribers;

    private Flipkart() {
        subscribers = new ArrayList<>();
    }

    public static Flipkart getInstance() {
        if (instance == null) {
            instance = new Flipkart();
        }
        return instance;
    }

    public void subscribe(OnOrderPlacedSubscriber subscriber) {
        if (!subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
        }
    }

    public void unsubscribe(OnOrderPlacedSubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void publishSubscribers() {
        for (OnOrderPlacedSubscriber subscriber : subscribers) {
            subscriber.announceOrderPlaced();
        }
    }
}
