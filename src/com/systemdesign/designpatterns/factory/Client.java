package com.systemdesign.designpatterns.factory;

import com.systemdesign.designpatterns.factory.components.Query;
import com.systemdesign.designpatterns.factory.components.SupportedDBFeature;
import com.systemdesign.designpatterns.factory.components.Transaction;

public class Client {
    public static void main(String[] args) {
        Application application = new Application();
        application.startApplication();
        application.createDatabaseConnection(SupportedDBFeature.MONGODB);
        Database database = application.getDatabase();
        Transaction transaction = database.createTransaction();
        transaction.createTransaction();
        Query query = database.createQuery();
        query.executeQuery();
        transaction.commitTransaction();
        application.stopApplication();
    }
}
