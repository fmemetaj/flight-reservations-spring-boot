package com.example.demo.model;

import java.time.LocalDate;

public class BookTicketRequest {
    private Airport departure;
    private Airport destination;
    private LocalDate date;

    public BookTicketRequest(Airport departure, Airport destination, LocalDate date) {
        this.departure = departure;
        this.destination = destination;
        this.date = date;
    }

    public Airport getDeparture() {
        return departure;
    }

    public void setDeparture(Airport departure) {
        this.departure = departure;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
