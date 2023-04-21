package com.example.thuchanhmd4.service;

public interface IGeneralService<T> {
    Iterable<T> findAll();
    T findById(Long id);
    void save(T t);
    void delete(Long id);
}
