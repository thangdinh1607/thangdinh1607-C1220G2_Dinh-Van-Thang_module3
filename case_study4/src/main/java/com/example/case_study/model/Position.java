package com.example.case_study.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="positions")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "position",cascade = CascadeType.ALL)
    private List<Employee> employees;
    public Position() {
    }

    public Position(String name, List<Employee> employees) {
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
