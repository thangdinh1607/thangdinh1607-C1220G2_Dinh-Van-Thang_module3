package com.example.case_study.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customerTypes")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "customerType",cascade = CascadeType.ALL)
    private List<Customer> customers;

    public CustomerType() {
    }

    public CustomerType(String name, List<Customer> customers) {
        this.name = name;
        this.customers = customers;
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

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
