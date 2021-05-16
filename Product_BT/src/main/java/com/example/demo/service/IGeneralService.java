package com.example.demo.service;

import java.util.List;

public interface IGeneralService <T>  {
    List<T> findAll();
    T findById(int id);
    void save(T t);
    void delete(int id);
}
