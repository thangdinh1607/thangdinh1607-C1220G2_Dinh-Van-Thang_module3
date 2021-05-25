package com.example.case_study.service.service;


import com.example.case_study.model.Service;
import com.example.case_study.repository.IServiceRepository;
import com.example.case_study.service.service.Impl.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService implements IServiceService {
    @Autowired
    private IServiceRepository iServiceRepository;


    @Override
    public List<Service> findAll() {
        return iServiceRepository.findAll();
    }

    @Override
    public Service findById(int id) {
        return iServiceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Service service) {
        iServiceRepository.save(service);
    }

    @Override
    public void remove(int id) {
        iServiceRepository.deleteById(id);
    }

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return iServiceRepository.findAll(pageable);
    }
}
