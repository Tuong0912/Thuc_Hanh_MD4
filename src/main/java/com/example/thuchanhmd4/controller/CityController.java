package com.example.thuchanhmd4.controller;

import com.example.thuchanhmd4.model.City;
import com.example.thuchanhmd4.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("city")
public class CityController {
    @Autowired
    private ICityService iCityService;

    @GetMapping
    public ResponseEntity<Iterable<City>> findAll() {
        return new ResponseEntity<>(iCityService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<City> findById(@PathVariable Long id) {
        return new ResponseEntity<>(iCityService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createNewCity(@RequestBody City city) {
        this.iCityService.save(city);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable Long id) {
        this.iCityService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
