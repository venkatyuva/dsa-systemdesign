package com.systemdesign.machinecoding.parkinglot.controller;

import com.systemdesign.machinecoding.parkinglot.dto.GenerateTicketRequestDto;
import com.systemdesign.machinecoding.parkinglot.dto.GenerateTicketResponseDto;
import com.systemdesign.machinecoding.parkinglot.service.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto requestDto) {
        return null;
    }
}
