package com.example.case_study.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "attach_service")
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Double cost;
    private int unit;
    private String status;
    @OneToMany(mappedBy = "attachService")
    private List<ContractDetail> contractDetails;

    public AttachService() {
    }

    public AttachService(String name, Double cost, int unit, String status, List<ContractDetail> contractDetails) {
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
        this.contractDetails = contractDetails;
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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
