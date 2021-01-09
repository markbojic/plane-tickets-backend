package com.raf.nwp.planetickets.controllers;

import com.raf.nwp.planetickets.model.Ticket;
import com.raf.nwp.planetickets.services.TicketService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/tickets")
public class TicketRestController {

    private final TicketService ticketService;

    public TicketRestController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Ticket> getAllTickets() {
        return ticketService.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.save(ticket);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Ticket updateTicket(@RequestBody Ticket ticket) {
        return ticketService.save(ticket);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable Long id) {
        Optional<Ticket> optionalTicket = ticketService.findById(id);
        if(optionalTicket.isPresent()) {
            //TODO dodaj da se brise sta bude trebalo
            ticketService.deleteById(id);
        } else {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
