package com.example.case_study.service.service_type;


import com.example.case_study.model.ServiceType;
import com.example.case_study.repository.IServiceTypeRepository;
import com.example.case_study.service.service_type.Impl.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeService implements IServiceTypeService {

    @Autowired
    private IServiceTypeRepository iServiceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return iServiceTypeRepository.findAll();
    }

    @Override
    public ServiceType findById(int id) {
        return iServiceTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ServiceType serviceType) {
        iServiceTypeRepository.save(serviceType);
    }

    @Override
    public void remove(int id) {
        iServiceTypeRepository.deleteById(id);
    }
}
