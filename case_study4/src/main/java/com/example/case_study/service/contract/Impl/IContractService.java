package com.example.case_study.service.contract.Impl;

import com.example.case_study.model.Contract;
import com.example.case_study.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService extends IGeneralService<Contract> {
    Page<Contract> findAll(Pageable pageable);
}
