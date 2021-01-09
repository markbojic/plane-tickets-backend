package com.raf.nwp.planetickets.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 64)
    private String username;
    @Size(min = 6)
    @Pattern(regexp = "^(?=\\P{L}*\\p{L})(?=\\P{N}*\\p{N})[\\s\\S]{6,}$") // ^ pocetak, prva () bar jedno slovo, druga () bar jedan broj, [\s\S]{6,} matchuje bilo koji karakter 6 ili vise puta, $ kraj
    private String password;
    @Column(nullable = false)
    private UserType userType;
    //TODO samo obican user ima bookings
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER)
    private List<Reservation> bookings = new ArrayList<>();

    public void addBooking(Reservation reservation){
        bookings.add(reservation);
    }
}
