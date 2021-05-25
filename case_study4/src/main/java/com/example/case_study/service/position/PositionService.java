package com.example.case_study.service.position;

import com.example.case_study.model.Position;
import com.example.case_study.repository.IPositionRepository;
import com.example.case_study.service.position.Impl.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {

    @Autowired
    private IPositionRepository iPositionRepository;

    @Override
    public List<Position> findAll() {
        return iPositionRepository.findAll();
    }

    @Override
    public Position findById(int id) {
        return iPositionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Position position) {
        iPositionRepository.save(position);
    }

    @Override
    public void remove(int id) {
        iPositionRepository.deleteById(id);
    }
}
