package com.raf.nwp.planetickets.services;

import com.raf.nwp.planetickets.model.Ticket;
import com.raf.nwp.planetickets.repositories.TicketRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService implements IService<Ticket, Long> {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Optional<Ticket> findById(Long ticketId) {
        return ticketRepository.findById(ticketId);
    }

    @Override
    public List<Ticket> findAll() {
        return (List<Ticket>) ticketRepository.findAll();
    }

    @Override
    public void deleteById(Long ticketId) {
        ticketRepository.deleteById(ticketId);
    }

    public List<Ticket> findByGivenParams(String origin, String destination, String departOn, String returnOn) {
        List<Ticket> all = this.findAll();
        System.out.println("org: " + origin + " dest: " + destination + " -> " + departOn + " <- " + returnOn);
        if(origin != null && !origin.equalsIgnoreCase("")) {
            all.removeIf(ticket -> !ticket.getFlight().getOrigin().getName().equalsIgnoreCase(origin));
        }
        if(destination != null && !destination.equalsIgnoreCase("")) {
            all.removeIf(ticket -> !ticket.getFlight().getDestination().getName().equalsIgnoreCase(destination));
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(departOn != null && !departOn.equalsIgnoreCase("")) {
            all.removeIf(ticket -> {
                boolean res = false;
                try {
                    String d1 = ticket.getDepartOn().toString();
                    //System.out.println(sdf.parse(d1) + " - " + sdf.parse(departOn).toString());
                    Date real = sdf.parse(d1);
                    Date limit = sdf.parse(departOn);
                    res = real.before(limit);
                } catch (ParseException e) {
                    System.out.println("DATE ERROR in TicketService");
                }
                return res;
            });
        }
        if(returnOn != null && !returnOn.equalsIgnoreCase("")) {
            all.removeIf(ticket -> {
                if(ticket.isOneWay()) return false; // one-way ticket
                boolean res = false;
                try {
                    Date real = sdf.parse(ticket.getReturnOn().toString());
                    Date limit = sdf.parse(returnOn);
                    res = real.after(limit);
                } catch (ParseException e) {
                    System.out.println("DATE ERROR in TicketService");
                }
                return res;
            });
        }

        return all;
    }
}
