package com.systemdesign.machinecoding.parkinglot.model;

import com.systemdesign.machinecoding.parkinglot.enums.PaymentMode;
import com.systemdesign.machinecoding.parkinglot.enums.PaymentStatus;

import java.util.Date;

public class Payment extends BaseEntity {
    private String transactionId;

    private PaymentMode paymentMode;

    private Date paymentTime;

    private double amount;

    private PaymentStatus paymentStatus;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
