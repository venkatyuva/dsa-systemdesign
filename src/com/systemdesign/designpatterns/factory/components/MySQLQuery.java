package com.systemdesign.designpatterns.factory.components;

public class MySQLQuery implements Query {

    @Override
    public void executeQuery() {
        System.out.println("Executing mysql query");
    }
}
