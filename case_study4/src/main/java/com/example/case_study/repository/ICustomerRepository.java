package com.example.case_study.repository;

import com.example.case_study.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository  extends JpaRepository<Customer,Integer> {
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByNameContainingAndAddressContainingAndEmailContaining(String name,String address,String email,Pageable pageable);
}
