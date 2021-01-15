package com.raf.nwp.planetickets.services;

import com.raf.nwp.planetickets.model.Airline;
import com.raf.nwp.planetickets.repositories.AirlineRepository;
import com.raf.nwp.planetickets.repositories.FlightRepository;
import com.raf.nwp.planetickets.repositories.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineService implements IService<Airline, Long> {

    private final AirlineRepository airlineRepository;

    public AirlineService(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    @Override
    public Airline save(Airline airline) {
        return airlineRepository.save(airline);
    }

    @Override
    public Optional<Airline> findById(Long airlineId) {
        return airlineRepository.findById(airlineId);
    }

    @Override
    public List<Airline> findAll() {
        return (List<Airline>) airlineRepository.findAll();
    }

    @Override
    public void deleteById(Long airlineId) {
        airlineRepository.deleteById(airlineId);
    }
}
