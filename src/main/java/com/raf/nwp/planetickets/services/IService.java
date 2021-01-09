package com.raf.nwp.planetickets.services;

import java.util.List;
import java.util.Optional;

public interface IService<T, ID> {
    T save(T var);

    Optional<T> findById(ID id);

    List<T> findAll();

    void deleteById(ID id);
}
