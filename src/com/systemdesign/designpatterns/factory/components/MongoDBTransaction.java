package com.systemdesign.designpatterns.factory.components;

public class MongoDBTransaction implements Transaction {

    @Override
    public void createTransaction() {
        System.out.println("Creating mongo DB transaction");
    }

    @Override
    public void commitTransaction() {
        System.out.println("Mongo DB transaction is committed");
    }
}
