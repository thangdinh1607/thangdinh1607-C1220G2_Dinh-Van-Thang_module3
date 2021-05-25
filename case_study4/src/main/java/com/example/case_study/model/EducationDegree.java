package com.example.case_study.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "educationDegrees")
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;


    @OneToMany(mappedBy = "educationDegree", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public EducationDegree() {
    }

    public EducationDegree(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
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
}
