package com.systemdesign.designpatterns.factory;

import com.systemdesign.designpatterns.factory.components.SupportedDBFeature;

public class DatabaseFactory {

    public static Database createDatabaseConnection(SupportedDBFeature database) {
        Database instance = null;
        if (SupportedDBFeature.MYSQL.equals(database)) {
            instance = new MySQLDatabase();
        } else if (SupportedDBFeature.POSTGRES.equals(database)) {
            instance = new PostgresDatabase();
        } else if (SupportedDBFeature.MONGODB.equals(database)) {
            instance = new MongoDBDatabase();
        }
        return instance;
    }
}
