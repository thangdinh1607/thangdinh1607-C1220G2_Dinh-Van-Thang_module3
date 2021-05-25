package com.example.case_study.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rentypes")
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double cost;


    @OneToMany(mappedBy = "rentType" ,cascade = CascadeType.ALL)
    private List<Service> services;

    public RentType() {
    }

    public RentType(String name, double cost, List<Service> services) {
        this.name = name;
        this.cost = cost;
        this.services = services;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
