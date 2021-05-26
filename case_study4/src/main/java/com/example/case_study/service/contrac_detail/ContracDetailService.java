package com.example.case_study.service.contrac_detail;

import com.example.case_study.model.Contract;
import com.example.case_study.model.ContractDetail;
import com.example.case_study.repository.IContractDetailRepository;
import com.example.case_study.service.contrac_detail.Impl.IContractDetailService;
import com.example.case_study.service.contract.Impl.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContracDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository iContractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return iContractDetailRepository.findAll();
    }

    @Override
    public ContractDetail findById(int id) {
        return iContractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        iContractDetailRepository.save(contractDetail);
    }

    @Override
    public void remove(int id) {
        iContractDetailRepository.deleteById(id);
    }

    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return iContractDetailRepository.findAll(pageable);
    }
}