package com.raf.nwp.planetickets.controllers;

import com.raf.nwp.planetickets.model.City;
import com.raf.nwp.planetickets.services.CityService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/cities")
public class CityRestController {

    private final CityService cityService;

    public CityRestController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<City> getAllCities() {
        return cityService.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public City createCity(@RequestBody City city) {
        return cityService.save(city);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public City updateCity(@RequestBody City city) {
        return cityService.save(city);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable Long id) {
        Optional<City> optionalCity = cityService.findById(id);
        if(optionalCity.isPresent()) {
            //TODO dodaj da se brise sta bude trebalo
            cityService.deleteById(id);
        } else {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
