package com.systemdesign.designpatterns.adapter;

import com.systemdesign.designpatterns.adapter.thirdparty.HDFCBankApi;

public class Client {
    public static void main(String[] args) {
        PhonePe phonePe = new PhonePe(new ICICIBankApi());
        phonePe.createAccount("9791562571");
        System.out.println(phonePe.fetchBalance("572833004"));
        phonePe.transact("572833004", "572833005", 50);
    }
}
