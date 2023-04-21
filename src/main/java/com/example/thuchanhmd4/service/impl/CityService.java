package com.example.thuchanhmd4.service.impl;

import com.example.thuchanhmd4.model.City;
import com.example.thuchanhmd4.repository.ICityRepository;
import com.example.thuchanhmd4.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService implements ICityService {
    @Autowired
    private ICityRepository iCityRepository;

    @Override
    public Iterable<City> findAll() {
        return iCityRepository.findAll();
    }

    @Override
    public City findById(Long id) {
        return iCityRepository.findById(id).orElse(null);
    }

    @Override
    public void save(City city) {
        iCityRepository.save(city);
    }

    @Override
    public void delete(Long id) {
        iCityRepository.deleteById(id);
    }
}
