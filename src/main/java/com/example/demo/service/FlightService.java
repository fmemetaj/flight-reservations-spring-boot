package com.example.demo.service;

import com.example.demo.model.Flight;
import com.example.demo.repository.FlightRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getAllFlights() {
        return null;
    }

    public Flight addFlight(Flight flight) {
        return null;
    }

    public Flight updateFlight(Long id, Flight updatedFlight) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found"));
        flight.setDeparture(updatedFlight.getDeparture());
        flight.setDestination(updatedFlight.getDestination());
        flight.setDepartureDate(updatedFlight.getDepartureDate());
        flight.setArrivalDate(updatedFlight.getArrivalDate());
        flight.setDepartureTime(updatedFlight.getDepartureTime());
        flight.setArrivalTime(updatedFlight.getArrivalTime());
        flightRepository.save(flight);
        return flight;
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }
}
