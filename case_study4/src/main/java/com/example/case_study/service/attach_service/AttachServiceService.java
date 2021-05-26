package com.example.case_study.service.attach_service;

import com.example.case_study.model.AttachService;
import com.example.case_study.repository.IAttachServiceRepository;
import com.example.case_study.service.attach_service.Impl.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceService implements IAttachServiceService {
    @Autowired
    private IAttachServiceRepository iAttachServiceRepository;

    @Override
    public List<AttachService> findAll() {
        return iAttachServiceRepository.findAll();
    }

    @Override
    public AttachService findById(int id) {
        return iAttachServiceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(AttachService attachService) {
        iAttachServiceRepository.save(attachService);
    }

    @Override
    public void remove(int id) {
        iAttachServiceRepository.deleteById(id);
    }
}
