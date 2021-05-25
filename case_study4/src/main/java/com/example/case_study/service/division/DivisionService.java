package com.example.case_study.service.division;

import com.example.case_study.model.Division;
import com.example.case_study.repository.IDivisionRepository;
import com.example.case_study.service.division.Impl.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DivisionService implements IDivisionService {
    @Autowired
    private IDivisionRepository iDivisionRepository;

    @Override
    public List<Division> findAll() {
        return iDivisionRepository.findAll();
    }

    @Override
    public Division findById(int id) {
        return iDivisionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Division division) {
        iDivisionRepository.save(division);
    }

    @Override
    public void remove(int id) {
        iDivisionRepository.deleteById(id);
    }
}
