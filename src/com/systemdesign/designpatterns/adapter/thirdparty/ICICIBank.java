package com.systemdesign.designpatterns.adapter.thirdparty;

public class ICICIBank {

    public double fetchBalance(String accountNumber) {
        System.out.println("Fetching ICICI Bank account balance");
        return 100;
    }

    public void transfer(double money, String fromAccount, String toAccount) {
        System.out.println("Using ICICI bank transferring amount: " + money + " from account: " + fromAccount + " to account: " + toAccount);
    }

    public void createAccount(String mobileNumber) {
        System.out.println("Creating account for mobile number: " + mobileNumber + " in ICICI bank");
    }
}
