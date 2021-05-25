package com.example.case_study.service.rent_type;

import com.example.case_study.model.RentType;
import com.example.case_study.repository.IRentTypeRepository;
import com.example.case_study.service.rent_type.Impl.IRentypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentypeService {

    @Autowired
    private IRentTypeRepository iRentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return iRentTypeRepository.findAll();
    }

    @Override
    public RentType findById(int id) {
        return iRentTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(RentType rentType) {
        iRentTypeRepository.save(rentType);
    }

    @Override
    public void remove(int id) {
        iRentTypeRepository.deleteById(id);
    }
}
