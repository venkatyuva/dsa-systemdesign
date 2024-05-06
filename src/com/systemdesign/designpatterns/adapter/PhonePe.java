package com.systemdesign.designpatterns.adapter;

public class PhonePe {

    private final BankApi bankApi;

    public PhonePe(BankApi bankApi) {
        this.bankApi = bankApi;
    }

    public void createAccount(String mobileNumber) {
        bankApi.register(mobileNumber);
    }

    public boolean transact(String fromAccount, String toAccount, double amount) {
        return bankApi.transfer(fromAccount, toAccount, amount);
    }

    public double fetchBalance(String accountNumber) {
        return bankApi.checkBalance(accountNumber);
    }
}
