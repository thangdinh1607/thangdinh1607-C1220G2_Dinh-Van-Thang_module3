package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface IGeneralService<T> {
    List<User> findAll();

    void delete(int id);

    void save(T t);
    User findById(int id);
}
