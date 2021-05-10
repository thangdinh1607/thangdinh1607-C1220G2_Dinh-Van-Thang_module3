package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService  extends IGeneralService<Customer>{
    Page<Customer> findAll(Pageable pageable );
    Page<Customer>findByFirstName(String name,Pageable pageable);
}
