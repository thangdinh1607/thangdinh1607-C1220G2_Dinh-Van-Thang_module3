package com.example.case_study.repository;

import com.example.case_study.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {
    User getUserByUsername(String name);
}
