package com.example.case_study.repository;

import com.example.case_study.model.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
    Page<ContractDetail> findAll(Pageable pageable);
}
