package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;

public interface IGeneralService<T> {
    void save(T t);
    List<Customer> findAll();
}
