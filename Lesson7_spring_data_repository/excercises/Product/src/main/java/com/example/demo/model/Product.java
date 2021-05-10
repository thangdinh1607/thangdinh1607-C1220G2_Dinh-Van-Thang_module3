package com.example.demo.model;

import org.springframework.data.web.PageableDefault;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productdetail_id" ,referencedColumnName = "id")
    private ProductDetail productDetail;

    public Product() {
    }

    public Product(int id, String name, ProductDetail productDetail) {
        this.id = id;
        this.name = name;
        this.productDetail = productDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }
}
