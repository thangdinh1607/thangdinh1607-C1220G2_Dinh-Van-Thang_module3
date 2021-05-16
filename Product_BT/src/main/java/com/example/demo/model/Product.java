package com.example.demo.model;

import org.springframework.data.web.PageableDefault;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min=5,max=30)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productdetail_id" ,referencedColumnName = "id")
    private ProductDetail productDetail;


    @ManyToOne()
    @JoinColumn(name="category_id",referencedColumnName = "id")
    private Category category;

    public Product() {
    }

    public Product(int id, String name, ProductDetail productDetail, Category category) {
        this.id = id;
        this.name = name;
        this.productDetail = productDetail;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
