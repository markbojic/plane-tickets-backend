package com.raf.nwp.planetickets.controllers;

import com.raf.nwp.planetickets.model.Airline;
import com.raf.nwp.planetickets.services.AirlineService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/airlines")
public class AirlineRestController {

    private final AirlineService airlineService;

    public AirlineRestController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Airline> getAllAirlines() {
        return airlineService.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Airline createAirline(@RequestBody Airline airline) {
        return airlineService.save(airline);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Airline updateAirline(@RequestBody Airline airline) {
        return airlineService.save(airline);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteAirline(@PathVariable Long id) {
        Optional<Airline> optionalAirline = airlineService.findById(id);
        if(optionalAirline.isPresent()) {
            //TODO dodaj da se brise sta bude trebalo
            airlineService.deleteById(id);
        } else {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
