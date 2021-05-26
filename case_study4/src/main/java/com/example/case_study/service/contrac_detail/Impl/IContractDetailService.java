package com.example.case_study.service.contrac_detail.Impl;

import com.example.case_study.model.ContractDetail;
import com.example.case_study.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractDetailService extends IGeneralService<ContractDetail> {
    Page<ContractDetail> findAll(Pageable pageable);
}
