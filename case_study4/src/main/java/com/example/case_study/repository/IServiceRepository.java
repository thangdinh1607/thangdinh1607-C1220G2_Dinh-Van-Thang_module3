package com.example.case_study.repository;

import com.example.case_study.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRepository  extends JpaRepository<Service,Integer> {
    Page<Service> findAll(Pageable pageable);
}
