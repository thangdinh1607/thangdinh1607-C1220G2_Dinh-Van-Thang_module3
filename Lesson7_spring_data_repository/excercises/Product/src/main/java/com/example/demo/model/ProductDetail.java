package com.example.demo.model;


import javax.persistence.*;

@Entity
@Table(name="productdetail")
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String detail;

    @OneToOne(mappedBy = "productDetail")
    private Product product;

    public ProductDetail() {
    }

    public ProductDetail(int id, String detail, Product product) {
        this.id = id;
        this.detail = detail;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

