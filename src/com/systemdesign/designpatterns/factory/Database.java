package com.systemdesign.designpatterns.factory;

import com.systemdesign.designpatterns.factory.components.Query;
import com.systemdesign.designpatterns.factory.components.Transaction;

public interface Database {
    Query createQuery();

    Transaction createTransaction();
}
