package com.example.thuchanhmd4.service.impl;

import com.example.thuchanhmd4.model.Country;
import com.example.thuchanhmd4.repository.ICountryRepository;
import com.example.thuchanhmd4.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService implements ICountryService {
    @Autowired
    private ICountryRepository iCountryRepository;

    @Override
    public Iterable<Country> findAll() {
        return iCountryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return iCountryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Country country) {
        iCountryRepository.save(country);
    }

    @Override
    public void delete(Long id) {
        iCountryRepository.deleteById(id);
    }
}
