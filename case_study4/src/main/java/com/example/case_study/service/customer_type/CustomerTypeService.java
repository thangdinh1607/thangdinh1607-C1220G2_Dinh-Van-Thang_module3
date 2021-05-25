package com.example.case_study.service.customer_type;


import com.example.case_study.model.CustomerType;
import com.example.case_study.repository.ICustomerTypeRepository;

import com.example.case_study.service.customer_type.Impl.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private  ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return iCustomerTypeRepository.findAll();
    }

    @Override
    public CustomerType findById(int id) {
        return null;
    }

    @Override
    public void save(CustomerType customerType) {

    }

    @Override
    public void remove(int id) {

    }
}
