package com.example.demo.controller;

import com.example.demo.model.BookTicketRequest;
import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/choose-flight")
    public ResponseEntity<Ticket> bookTicket(@RequestBody BookTicketRequest bookTicketRequest) {
        Ticket bookedTicket = ticketService.bookTicket(bookTicketRequest.getDeparture(), bookTicketRequest.getDestination(), bookTicketRequest.getDate());
        if (bookedTicket != null) {
            return new ResponseEntity<>(bookedTicket, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
