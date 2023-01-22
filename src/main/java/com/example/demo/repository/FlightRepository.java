package com.example.demo.repository;

import com.example.demo.model.Airport;
import com.example.demo.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByDepartureEqualsAndDestinationEqualsAndDepartureDate(Airport departure, Airport destination, LocalDate departureDate);
    Flight getFlightById(Long id);
}
