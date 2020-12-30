package com.raf.nwp.planetickets.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "TICKETS")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "AIRLINE_ID", referencedColumnName = "ID", nullable = false)
    private Airline airline;
    @Column(nullable = false)
    private boolean oneWay;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date departOn;
    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Date returnOn; // null if oneWay = true
    @ManyToOne
    @JoinColumn(name = "FLIGHT_ID", referencedColumnName = "ID")
    private Flight flight;
    private Long count; // count >= 0
}
