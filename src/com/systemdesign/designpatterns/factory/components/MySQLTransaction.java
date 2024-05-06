package com.systemdesign.designpatterns.factory.components;

public class MySQLTransaction implements Transaction {

    @Override
    public void createTransaction() {
        System.out.println("Creating mysql transaction");
    }

    @Override
    public void commitTransaction() {
        System.out.println("MySQL Transaction is committed");
    }
}
