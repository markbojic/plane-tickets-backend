package com.raf.nwp.planetickets.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CITIES")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
}
