package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reservation_name")
    private String reservationName;

    @Column(name = "reservation_lastname")
    private String reservationLastname;

    @ManyToOne
    @JoinColumn
    private Flight flight;

    @Column(name = "seat_number")
    private Integer seatNumber;

    @Transient
    private Integer cost;

    public Ticket(String reservationName, String reservationLastname,
                  Flight flight, Integer seatNumber, Integer cost) {
        this.reservationName = reservationName;
        this.reservationLastname = reservationLastname;
        this.flight = flight;
        this.seatNumber = seatNumber;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Your ticket has this information: " + '\n' + '\n' +
                "Serial number : " + id + '\n' +
                "Name and Surname : " + reservationName + " " + reservationLastname + '\n' +
                "From " + flight.getDeparture().toString() + " to " + flight.getDestination().toString() + '\n' +
                "Date of departure : " + flight.getDepartureDate() + '\n' +
                "Departure Time : " + flight.getDepartureTime() + '\n' +
                "Date of arrival : " + flight.getArrivalDate() + '\n' +
                "Arrival Time : " + flight.getArrivalTime() + '\n' +
                "Seat number : " + seatNumber + '\n' +
                "Total Cost = " + cost + " USD";
    }
}
