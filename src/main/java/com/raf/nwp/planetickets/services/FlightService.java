package com.raf.nwp.planetickets.services;

import com.raf.nwp.planetickets.model.Flight;
import com.raf.nwp.planetickets.repositories.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService implements IService<Flight, Long> {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Optional<Flight> findById(Long flightId) {
        return flightRepository.findById(flightId);
    }

    @Override
    public List<Flight> findAll() {
        return (List<Flight>) flightRepository.findAll();
    }

    @Override
    public void deleteById(Long flightId) {
        flightRepository.deleteById(flightId);
    }
}
