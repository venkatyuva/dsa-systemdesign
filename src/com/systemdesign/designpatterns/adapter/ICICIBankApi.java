package com.systemdesign.designpatterns.adapter;

import com.systemdesign.designpatterns.adapter.thirdparty.ICICIBank;

public class ICICIBankApi implements BankApi {

    private final ICICIBank iciciBank = new ICICIBank();
    @Override
    public double checkBalance(String accountNumber) {
        return iciciBank.fetchBalance(accountNumber);
    }

    @Override
    public boolean transfer(String fromAccount, String toAccount, double money) {
        try {
            iciciBank.transfer(money, fromAccount, toAccount);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public void register(String mobileNumber) {
        iciciBank.createAccount(mobileNumber);
    }
}
