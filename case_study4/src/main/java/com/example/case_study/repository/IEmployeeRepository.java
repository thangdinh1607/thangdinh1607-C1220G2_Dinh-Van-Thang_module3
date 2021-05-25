package com.example.case_study.repository;

import com.example.case_study.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    Page<Employee> findAll(Pageable pageable);
}
