package com.example.websevice.service.customer;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();
    T findById(int id);
    T save(T t);
    void remove(int id);
}
