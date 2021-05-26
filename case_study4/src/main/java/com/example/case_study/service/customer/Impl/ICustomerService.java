package com.example.case_study.service.customer.Impl;

import com.example.case_study.model.Customer;
import com.example.case_study.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService extends IGeneralService<Customer> {
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByNameContainingAndAddressContainingAndEmailContaining(String name,String address,String email,Pageable pageable);
}
