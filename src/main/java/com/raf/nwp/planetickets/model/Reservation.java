package com.raf.nwp.planetickets.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "RESERVATIONS")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isAvailable;
    @ManyToOne
    @JoinColumn(name = "FLIGHT_ID", referencedColumnName = "ID", nullable = false)
    private Flight flight;
    @ManyToOne
    @JoinColumn(name = "TICKET_ID", referencedColumnName = "ID", nullable = false)
    private Ticket ticket;
}
