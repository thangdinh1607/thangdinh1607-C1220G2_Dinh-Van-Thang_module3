package com.example.phone.service;

import com.example.phone.model.Smartphone;
import com.example.phone.repository.ISmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartphoneService implements ISmartphoneService {
    @Autowired
    ISmartphoneRepository iSmartphoneRepository;

    @Override
    public List<Smartphone> findAll() {
        return iSmartphoneRepository.findAll();
    }

    @Override
    public Smartphone findById(int id) {
        return iSmartphoneRepository.findById(id).orElse(null);
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
       return iSmartphoneRepository.save(smartphone);
    }

    @Override
    public void remove(int id) {
        iSmartphoneRepository.deleteById(id);
    }
}
