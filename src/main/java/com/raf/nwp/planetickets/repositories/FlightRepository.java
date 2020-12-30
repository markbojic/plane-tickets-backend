package com.raf.nwp.planetickets.repositories;

import com.raf.nwp.planetickets.model.Flight;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, Long> {
}
