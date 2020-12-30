package com.raf.nwp.planetickets.repositories;

import com.raf.nwp.planetickets.model.Airline;
import org.springframework.data.repository.CrudRepository;

public interface AirlineRepository extends CrudRepository<Airline, Long> {
}
