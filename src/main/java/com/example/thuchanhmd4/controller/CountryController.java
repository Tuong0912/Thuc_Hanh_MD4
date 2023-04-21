package com.example.thuchanhmd4.controller;

import com.example.thuchanhmd4.model.Country;
import com.example.thuchanhmd4.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("country")
@CrossOrigin("*")
public class CountryController {
    @Autowired
    private ICountryService iCountryService;

    @GetMapping
    public ResponseEntity<Iterable<Country>> findAll() {
        return  new ResponseEntity<>(iCountryService.findAll(), HttpStatus.OK);
    }


}
