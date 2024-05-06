package com.systemdesign.designpatterns.factory.components;

public class PostegresQuery implements Query {

    @Override
    public void executeQuery() {
        System.out.println("Executing postgres query");
    }
}
