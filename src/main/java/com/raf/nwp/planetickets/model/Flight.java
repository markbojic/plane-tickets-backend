package com.raf.nwp.planetickets.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "FLIGHTS")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @OneToMany(mappedBy = "flight", fetch = FetchType.EAGER)
    private List<Ticket> tickets = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "FROM_ID", referencedColumnName = "ID", nullable = false)
    private City origin;
    @ManyToOne
    @JoinColumn(name = "DEST_ID", referencedColumnName = "ID", nullable = false)
    private City destination;

    public int getSize() {
        return this.tickets.size();
    }

    public void addTicket(Ticket ticket){
        tickets.add(ticket);
    }
}
