package com.systemdesign.machinecoding.parkinglot.dto;

import com.systemdesign.machinecoding.parkinglot.enums.ResponseStatus;
import com.systemdesign.machinecoding.parkinglot.model.Ticket;

public class GenerateTicketResponseDto {

    private Ticket ticket;

    private ResponseStatus responseStatus;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
