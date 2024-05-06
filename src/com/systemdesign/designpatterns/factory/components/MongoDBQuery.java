package com.systemdesign.designpatterns.factory.components;

public class MongoDBQuery implements Query {

    @Override
    public void executeQuery() {
        System.out.println("Executing mongo DB query");
    }
}
