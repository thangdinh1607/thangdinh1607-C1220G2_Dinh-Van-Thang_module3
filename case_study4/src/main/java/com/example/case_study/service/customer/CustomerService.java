package com.example.case_study.service.customer;

import com.example.case_study.model.Customer;
import com.example.case_study.repository.ICustomerRepository;
import com.example.case_study.service.customer.Impl.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void remove(int id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllByNameContainingAndAddressContainingAndEmailContaining(String name, String address, String email,Pageable pageable) {
        return iCustomerRepository.findAllByNameContainingAndAddressContainingAndEmailContaining(name,address,email,pageable);
    }
}
