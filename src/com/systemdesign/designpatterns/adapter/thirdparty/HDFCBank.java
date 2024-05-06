package com.systemdesign.designpatterns.adapter.thirdparty;

public class HDFCBank {

    public double getBalance(String accountNumber) {
        System.out.println("Fetching HDFC Bank account balance");
        return 50;
    }

    public boolean sendMoney(String fromAccount, double money, String toAccount) {
        System.out.println("Using HDFC bank transferring amount: " + money + " from account: " + fromAccount + " to account: " + toAccount);
        return true;
    }

    public void signUp(String phoneNumber) {
        System.out.println("Creating account for mobile number: " + phoneNumber + " in HDFC bank");
    }
}
