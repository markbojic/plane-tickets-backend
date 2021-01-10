package com.raf.nwp.planetickets.repositories;

import com.raf.nwp.planetickets.model.MyUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<MyUser, Long> {

    MyUser findByUsername(String username);
}
