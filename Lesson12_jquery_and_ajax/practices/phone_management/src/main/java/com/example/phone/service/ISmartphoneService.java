package com.example.phone.service;

import com.example.phone.model.Smartphone;

import java.util.List;

public interface ISmartphoneService {
    List<Smartphone> findAll();
    Smartphone findById(int id);
    Smartphone save(Smartphone smartphone);
    void remove(int id);
}
