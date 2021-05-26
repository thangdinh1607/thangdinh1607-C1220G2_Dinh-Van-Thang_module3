package com.example.case_study.service.contract;

import com.example.case_study.model.Contract;
import com.example.case_study.repository.IContractRepository;
import com.example.case_study.service.contract.Impl.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public List<Contract> findAll() {
        return iContractRepository.findAll();
    }

    @Override
    public Contract findById(int id) {
        return iContractRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public void remove(int id) {
        iContractRepository.deleteById(id);
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return iContractRepository.findAll(pageable);
    }
}
