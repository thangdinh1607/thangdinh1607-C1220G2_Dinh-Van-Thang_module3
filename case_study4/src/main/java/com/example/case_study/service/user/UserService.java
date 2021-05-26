package com.example.case_study.service.user;

import com.example.case_study.model.User;
import com.example.case_study.repository.IUserRepository;
import com.example.case_study.service.user.Impl.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }

    @Override
    public void remove(int id) {
    }
}
