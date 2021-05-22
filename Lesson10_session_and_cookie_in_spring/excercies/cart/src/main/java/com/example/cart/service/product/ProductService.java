package com.example.cart.service.product;

import com.example.cart.model.Product;
import com.example.cart.repository.ICategoryRepository;
import com.example.cart.repository.IProductRepository;
import com.example.cart.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public List<Product> findAllByNameContaining(String string) {
        return iProductRepository.findAllByNameContaining(string);
    }

}
