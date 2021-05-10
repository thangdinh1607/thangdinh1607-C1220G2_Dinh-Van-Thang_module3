package com.example.demo.service;

import com.example.demo.model.Province;
import com.example.demo.repository.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService implements IProvinceService {

    @Autowired
    IProvinceRepository iProvinceRepository;

    @Override
    public List<Province> findAll() {
        return iProvinceRepository.findAll();
    }

    @Override
    public Province findById(Long id) {
        return iProvinceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Province province) {
        iProvinceRepository.save(province);
    }

    @Override
    public void remove(Long id) {
        iProvinceRepository.deleteById(id);
    }
}
