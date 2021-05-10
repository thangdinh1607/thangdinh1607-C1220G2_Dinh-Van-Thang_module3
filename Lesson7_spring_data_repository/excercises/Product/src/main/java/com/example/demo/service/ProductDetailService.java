package com.example.demo.service;

import com.example.demo.model.ProductDetail;
import com.example.demo.repository.IProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailService implements IProductDetailService {
    @Autowired
    IProductDetailRepository iProductDetailRepository;

    @Override
    public List<ProductDetail> findAll() {
        return iProductDetailRepository.findAll();
    }

    @Override
    public ProductDetail findById(int id) {
        return iProductDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ProductDetail productDetail) {
        iProductDetailRepository.save(productDetail);
    }

    @Override
    public void delete(int id) {
        iProductDetailRepository.deleteById(id);
    }
}
