package com.example.demo.repository;

import com.example.demo.model.Product;
import com.example.demo.model.ProductDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductDetailRepository extends JpaRepository<ProductDetail,Integer> {

}
