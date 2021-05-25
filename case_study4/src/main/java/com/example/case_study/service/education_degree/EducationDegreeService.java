package com.example.case_study.service.education_degree;

import com.example.case_study.model.EducationDegree;
import com.example.case_study.repository.IEducationDegreeRepository;
import com.example.case_study.service.education_degree.impl.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeService implements IEducationDegreeService {
    @Autowired
    private IEducationDegreeRepository iEducationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return iEducationDegreeRepository.findAll();
    }

    @Override
    public EducationDegree findById(int id) {
        return iEducationDegreeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(EducationDegree educationDegree) {
        iEducationDegreeRepository.save(educationDegree);
    }

    @Override
    public void remove(int id) {
        iEducationDegreeRepository.deleteById(id);
    }
}
