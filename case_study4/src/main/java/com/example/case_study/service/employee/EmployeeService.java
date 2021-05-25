package com.example.case_study.service.employee;

import com.example.case_study.model.Employee;
import com.example.case_study.repository.IEmployeeRepository;
import com.example.case_study.service.employee.Impl.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return iEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public void remove(int id) {
        iEmployeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return iEmployeeRepository.findAll(pageable);
    }
}
