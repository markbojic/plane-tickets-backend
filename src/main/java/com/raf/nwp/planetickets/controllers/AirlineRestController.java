package com.raf.nwp.planetickets.controllers;

import com.raf.nwp.planetickets.model.Airline;
import com.raf.nwp.planetickets.model.Ticket;
import com.raf.nwp.planetickets.repositories.FlightRepository;
import com.raf.nwp.planetickets.repositories.TicketRepository;
import com.raf.nwp.planetickets.services.AirlineService;
import com.raf.nwp.planetickets.services.TicketService;
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
    private final TicketService ticketService;
    private final TicketRepository ticketRepository;
    private final FlightRepository flightRepository;

    public AirlineRestController(AirlineService airlineService, TicketService ticketService, TicketRepository ticketRepository, FlightRepository flightRepository) {
        this.airlineService = airlineService;
        this.ticketService = ticketService;
        this.ticketRepository = ticketRepository;
        this.flightRepository = flightRepository;
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
            List<Ticket> tickets = ticketService.findAll();
            for (int i = 0; i < tickets.size(); i++) {
                Ticket tmp = tickets.get(i);
                if (tmp.getAirline().getId() == id) {
                    // delete this ticket from flight
                    tmp.getFlight().removeTicket(tmp);
                    flightRepository.save(tmp.getFlight());
                    // delete ticket
                    ticketRepository.deleteById(tmp.getId());
                }
            }
            // delete airline
            airlineService.deleteById(id);
        } else {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
