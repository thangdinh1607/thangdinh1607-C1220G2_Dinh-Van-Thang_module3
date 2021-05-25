package com.example.case_study.service.service.Impl;

import com.example.case_study.model.Service;
import com.example.case_study.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceService extends IGeneralService<Service> {
    Page<Service> findAll(Pageable pageable);
}
