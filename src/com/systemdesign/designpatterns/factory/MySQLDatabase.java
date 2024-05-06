package com.systemdesign.designpatterns.factory;

import com.systemdesign.designpatterns.factory.components.MySQLQuery;
import com.systemdesign.designpatterns.factory.components.MySQLTransaction;
import com.systemdesign.designpatterns.factory.components.Query;
import com.systemdesign.designpatterns.factory.components.Transaction;

public class MySQLDatabase implements Database {

    @Override
    public Query createQuery() {
        return new MySQLQuery();
    }

    @Override
    public Transaction createTransaction() {
        return new MySQLTransaction();
    }
}
