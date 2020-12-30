package com.raf.nwp.planetickets.repositories;

import com.raf.nwp.planetickets.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
