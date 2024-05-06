package com.systemdesign.designpatterns.adapter;

public interface BankApi {

    double checkBalance(String accountNumber);

    boolean transfer(String fromAccount, String toAccount, double money);

    void register(String mobileNumber);
}
