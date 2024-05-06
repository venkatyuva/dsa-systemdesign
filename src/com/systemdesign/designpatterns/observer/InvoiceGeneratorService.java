package com.systemdesign.designpatterns.observer;

public class InvoiceGeneratorService implements OnOrderPlacedSubscriber {

    private final Flipkart flipkart = Flipkart.getInstance();

    public InvoiceGeneratorService() {
        subscribeFlipkart();
    }

    @Override
    public void subscribeFlipkart() {
        flipkart.subscribe(this);
    }

    @Override
    public void unsubscribeFlipkart() {
        flipkart.unsubscribe(this);
    }

    @Override
    public void announceOrderPlaced() {
        System.out.println("Executing inventory generator service");
    }
}
