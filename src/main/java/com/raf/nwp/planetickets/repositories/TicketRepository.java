package com.raf.nwp.planetickets.repositories;

import com.raf.nwp.planetickets.model.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
