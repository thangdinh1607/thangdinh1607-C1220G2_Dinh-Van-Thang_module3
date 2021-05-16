package com.example.demo.service.product;

import com.example.demo.model.Product;
import com.example.demo.repository.IProductRepository;
import com.example.demo.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public interface IProductService extends IGeneralService<Product> {
    Page<Product> findAll(Pageable pageable);
}
