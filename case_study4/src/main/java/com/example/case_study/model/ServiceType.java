package com.example.case_study.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "serviceTypes")
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "serviceType" ,cascade = CascadeType.ALL)
    private List<Service> services;

    public ServiceType() {
    }

    public ServiceType(String name, List<Service> services) {
        this.name = name;
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

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
