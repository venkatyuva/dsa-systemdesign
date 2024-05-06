package com.systemdesign.designpatterns.factory;

import com.systemdesign.designpatterns.factory.components.SupportedDBFeature;

public class Application {

    private Database database;
    public void showApplication() {
        System.out.println("This is web application");
    }

    public void startApplication() {
        System.out.println("Starting application");
    }

    public void stopApplication() {
        System.out.println("Application is stopped");
    }

    public void createDatabaseConnection(SupportedDBFeature supportedDBFeature) {
        database = DatabaseFactory.createDatabaseConnection(supportedDBFeature);
    }

    public Database getDatabase() {
        return this.database;
    }
}
