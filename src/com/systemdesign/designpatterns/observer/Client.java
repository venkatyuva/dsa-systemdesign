package com.systemdesign.designpatterns.observer;

public class Client {
    public static void main(String[] args) {
        InventoryService inventoryService = new InventoryService();
        EmailService emailService = new EmailService();
        InvoiceGeneratorService invoiceGeneratorService = new InvoiceGeneratorService();
        Flipkart flipkart = Flipkart.getInstance();
        flipkart.publishSubscribers();
        System.out.println("==================================");
        inventoryService.unsubscribeFlipkart();
        flipkart.publishSubscribers();
        System.out.println("==================================");
        emailService.unsubscribeFlipkart();
        flipkart.publishSubscribers();
        System.out.println("==================================");
        invoiceGeneratorService.unsubscribeFlipkart();
        flipkart.publishSubscribers();
        System.out.println("==================================");
    }
}
