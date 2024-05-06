package com.systemdesign.designpatterns.factory;

import com.systemdesign.designpatterns.factory.components.MongoDBQuery;
import com.systemdesign.designpatterns.factory.components.MongoDBTransaction;
import com.systemdesign.designpatterns.factory.components.Query;
import com.systemdesign.designpatterns.factory.components.Transaction;

public class MongoDBDatabase implements Database {

    @Override
    public Query createQuery() {
        return new MongoDBQuery();
    }

    @Override
    public Transaction createTransaction() {
        return new MongoDBTransaction();
    }
}
