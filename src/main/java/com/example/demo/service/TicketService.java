package com.example.demo.service;

import com.example.demo.model.Airport;
import com.example.demo.model.Ticket;
import com.example.demo.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TicketService {

    private TicketRepository ticketRepository;

    public Ticket bookTicket(Airport departure, Airport destination, LocalDate date) {
        return null;
    }
}
