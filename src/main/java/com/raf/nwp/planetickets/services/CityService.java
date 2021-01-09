package com.raf.nwp.planetickets.services;

import com.raf.nwp.planetickets.model.City;
import com.raf.nwp.planetickets.repositories.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService implements IService<City, Long> {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public Optional<City> findById(Long cityId) {
        return cityRepository.findById(cityId);
    }

    @Override
    public List<City> findAll() {
        return (List<City>) cityRepository.findAll();
    }

    @Override
    public void deleteById(Long cityId) {
        cityRepository.deleteById(cityId);
    }
}
