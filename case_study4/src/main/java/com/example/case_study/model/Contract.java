package com.example.case_study.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "contracts")
public class Contract {
    @Id
    private int id;
    @NotEmpty(message = "input star date")
    private String startDate;
    @NotEmpty(message = "input end date")
    private String endDate;
    @NotNull
    @Min(value = 50, message = "deposit >50")
    private Double deposit;
    @NotNull
    @Min(value = 1, message = "total >1")
    private Double totalMoney;
    @ManyToOne
    @JoinColumn(name = "employye_id", referencedColumnName = "id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "sevice_id", referencedColumnName = "id")
    private Service service;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    List<ContractDetail> contractDetails;

    public Contract(String startDate, String endDate, Double deposit, Double totalMoney, Employee employee, Customer customer, Service service, List<ContractDetail> contractDetails) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
        this.contractDetails = contractDetails;
    }

    public Contract() {
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
