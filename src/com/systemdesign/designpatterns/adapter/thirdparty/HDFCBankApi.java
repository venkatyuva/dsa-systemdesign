package com.systemdesign.designpatterns.adapter.thirdparty;

import com.systemdesign.designpatterns.adapter.BankApi;

public class HDFCBankApi implements BankApi {

    private final HDFCBank hdfcBank = new HDFCBank();
    @Override
    public double checkBalance(String accountNumber) {
        return hdfcBank.getBalance(accountNumber);
    }

    @Override
    public boolean transfer(String fromAccount, String toAccount, double money) {
        return hdfcBank.sendMoney(fromAccount, money, toAccount);
    }

    @Override
    public void register(String mobileNumber) {
        hdfcBank.signUp(mobileNumber);
    }
}
