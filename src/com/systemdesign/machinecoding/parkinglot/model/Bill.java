package com.systemdesign.machinecoding.parkinglot.model;

import com.systemdesign.machinecoding.parkinglot.enums.BillStatus;

import java.util.Date;
import java.util.List;

public class Bill extends BaseEntity {
    private String billNumber;

    private Ticket ticket;

    private Date exitTime;

    private double amount;

    private List<Payment> payments;

    private BillStatus billStatus;

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }
}
