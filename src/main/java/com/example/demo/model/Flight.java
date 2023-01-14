package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Airport departure;

    @Enumerated(EnumType.STRING)
    private Airport destination;

    @Column(name = "departure_date")
    private LocalDate departureDate;

    @Column(name = "arrival_date")
    private LocalDate arrivalDate;

    @Column(name = "departure_time")
    private LocalTime departureTime;

    @Column(name = "arrival_time")
    private LocalTime arrivalTime;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Ticket> tickets = new HashSet<>();

    public Flight(Airport departure, Airport destination,
                  LocalDate departureDate, LocalDate arrivalDate,
                  LocalTime departureTime, LocalTime arrivalTime,
                  Set<Ticket> tickets) {
        this.departure = departure;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "Flight from " + departure +
                " to " + destination +
                ", departure time : " + departureTime +
                " and arrival time : " + arrivalTime;
    }

    public Double distanceKm() {

        Double departureLongitude = Math.toRadians(this.departure.getLongitude());
        Double destinationLongitude = Math.toRadians(this.destination.getLongitude());
        Double departureLatitude = Math.toRadians(this.departure.getLatitude());
        Double destinationLatitude = Math.toRadians(this.destination.getLatitude());

        // Haversine formula
        Double differenceLongitude = destinationLongitude - departureLongitude;
        Double differenceLatitude = destinationLatitude - departureLatitude;
        Double a = Math.pow(Math.sin(differenceLatitude / 2), 2)
                + Math.cos(departureLatitude) * Math.cos(destinationLatitude)
                * Math.pow(Math.sin(differenceLongitude / 2), 2);

        Double c = 2 * Math.asin(Math.sqrt(a));

        Double r = 6371.0;

        return (c * r);
    }
}
