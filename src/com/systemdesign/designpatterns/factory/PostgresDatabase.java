package com.systemdesign.designpatterns.factory;

import com.systemdesign.designpatterns.factory.components.PostegresQuery;
import com.systemdesign.designpatterns.factory.components.PostgresTransaction;
import com.systemdesign.designpatterns.factory.components.Query;
import com.systemdesign.designpatterns.factory.components.Transaction;

public class PostgresDatabase implements Database {
    @Override
    public Query createQuery() {
        return new PostegresQuery();
    }

    @Override
    public Transaction createTransaction() {
        return new PostgresTransaction();
    }
}
