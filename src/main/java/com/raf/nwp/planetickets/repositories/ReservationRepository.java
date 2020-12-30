package com.raf.nwp.planetickets.repositories;

import com.raf.nwp.planetickets.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
