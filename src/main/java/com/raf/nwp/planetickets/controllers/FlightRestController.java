package com.raf.nwp.planetickets.controllers;

import com.raf.nwp.planetickets.model.Flight;
import com.raf.nwp.planetickets.services.FlightService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/flights")
public class FlightRestController {

    private final FlightService flightService;

    public FlightRestController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Flight> getAllFlights() {
        return flightService.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Flight createFlight(@RequestBody Flight flight) {
        return flightService.save(flight);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Flight updateFlight(@RequestBody Flight flight) {
        return flightService.save(flight);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteFlight(@PathVariable Long id) {
        Optional<Flight> optionalFlight = flightService.findById(id);
        if(optionalFlight.isPresent()) {
            //TODO dodaj da se brise sta bude trebalo
            flightService.deleteById(id);
        } else {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
