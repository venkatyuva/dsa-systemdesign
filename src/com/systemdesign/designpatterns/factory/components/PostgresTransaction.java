package com.systemdesign.designpatterns.factory.components;

public class PostgresTransaction implements Transaction {

    @Override
    public void createTransaction() {
        System.out.println("Creating postgres transaction");
    }

    @Override
    public void commitTransaction() {
        System.out.println("Postgres transaction is committed");
    }
}
