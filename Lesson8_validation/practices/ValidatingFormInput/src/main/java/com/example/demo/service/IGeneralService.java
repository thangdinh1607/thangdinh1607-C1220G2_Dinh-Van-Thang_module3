package com.example.demo.service;

import java.util.List;

public interface IGeneralService <T> {
    List<T> findAll();
    void save(T t);
}
