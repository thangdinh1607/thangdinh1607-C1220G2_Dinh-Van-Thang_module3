package com.example.case_study.service.employee.Impl;

import com.example.case_study.model.Employee;
import com.example.case_study.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService extends IGeneralService<Employee> {
    Page<Employee> findAll(Pageable pageable);
}
