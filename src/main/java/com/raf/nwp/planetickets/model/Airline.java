package com.raf.nwp.planetickets.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Data
@Entity
@Table(name = "AIRLINES")
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    //@Pattern(regexp = "^(?=\\p{Alnum})+$") // [A-Za-z0-9]
    private String name;
}
